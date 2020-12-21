package res.main;


import res.frames.*;
import res.problem.*;
import res.utils.Check;
import res.utils.Read;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private final int port = 8998;
    private DataInputStream dis;
    private DataOutputStream dos;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Socket socket;
    private Integer msgCount = 0;
    private JFrame frame;

    private File examFile;


    private ArrayList<SingleProblem> singleProblems;
    private ArrayList<MultyProblem> multyProblems;
    private ArrayList<JudgeProblem> judgeProblems;

    private ArrayList<JPanel> panels;

    private ArrayList<ArrayList<Integer>> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        //启动服务器
        Server server = new Server();
        server.startServer();
    }


    private void startListen() {
        new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                    try {
                        if (dis != null && !socket.isClosed()) {
                            handling(dis.readUTF());
                            msgCount++;
                            System.out.println(msgCount + "  正在处理数据");
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        // TODO Auto-generated catch block
                        System.out.println("客户端未连接");
                        break;
                    }
                }
            }
        }.start();
    }

    public void startServer() throws IOException {
        initialize();
        ServerSocket serverSocket = new ServerSocket(port);
        try {
            socket = serverSocket.accept();
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            startListen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("\u6559\u5E08\u76D1\u8003\u7AEF");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel label1 = new JLabel("\u8003\u8BD5\u7CFB\u7EDF---\u6559\u5E08\u7AEF");
        label1.setFont(new Font("幼圆", Font.PLAIN, 45));
        label1.setBounds(200, 50, 400, 200);
        label1.setForeground(new Color(109, 126, 86));
        label1.setFont(new Font("幼圆", Font.PLAIN, 45));
        frame.getContentPane().add(label1);

        JButton sumbit = new JButton("\u767B\u5F55");
        sumbit.setBounds(320, 378, 160, 75);
        sumbit.setForeground(new Color(125, 148, 92));
        sumbit.setFont(new Font("幼圆", Font.PLAIN, 35));
        frame.getContentPane().add(sumbit);
        frame.setVisible(true);

        sumbit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            //关闭欢迎界面的frame
                            frame.dispose();
                            //显示分发试卷页面
                            ServerFrame window = new ServerFrame();
                            window.frame.setVisible(true);
                            // 获取文件
                            new Thread() {
                                @Override
                                public void run() {
                                    super.run();
                                    while (true) {
                                        try {
                                            if (window.paper != null) {
                                                examFile = (File) window.paper;
                                                // 创建每个题目对象
                                                creatProblems();
                                                creatPanels();
                                                break;
                                            } else {
                                                Thread.sleep(1000);
                                            }
                                        } catch (InterruptedException | IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }.start();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void creatProblems() throws IOException {
        Read read = new Read(examFile.getPath());
        singleProblems = read.get_singleProblems();
        multyProblems = read.get_MultyProblems();
        judgeProblems = read.get_JudgeProblems();
    }

    private void creatPanels() {
        panels = new ArrayList<>();
        JPanel panel;
        for (SingleProblem p : singleProblems) {
            panel = new SinglePanel(p);
            panel.setVisible(false);
            panels.add(panel);
        }
        for (MultyProblem p : multyProblems) {
            panel = new MultyPanel(p);
            panel.setVisible(false);
            panels.add(panel);
        }
        for (JudgeProblem p : judgeProblems) {
            panel = new JudgePanel(p);
            panel.setVisible(false);
            panels.add(panel);
        }
    }

    /**
     * 事件处理,分行字符串
     * 第一行为区分操作
     * log,登录验证
     * paper,试卷请求
     * return,回传答案
     *
     * @param msg
     * @return true false
     */
    private void handling(String msg) throws Exception {
        String[] ans = msg.split("\n");
        if (ans[0].equals("log")) {
            Check check = new Check();
            if (check.checkStudent(ans[1], ans[2])) {
                dos.writeUTF("true");
                check.updateStudent(ans[1]);
            } else {
                dos.writeUTF("false");
            }
            dos.flush();
        } else if (ans[0].equals("paper")) {
            dos.writeUTF(panels.size() + "");
            dos.flush();
            for (JPanel p : panels) {
                try {
                    oos.writeObject(p);
                    oos.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ans[0].equals("return")) {
            answers.clear();
            answers = (ArrayList<ArrayList<Integer>>) ois.readObject();
        } else if (ans[0].equals("")) {

        }
    }
}