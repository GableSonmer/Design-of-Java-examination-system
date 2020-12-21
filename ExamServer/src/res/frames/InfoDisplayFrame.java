package res.frames;

import jdk.swing.interop.SwingInterOpUtils;
import res.utils.Check;
import res.utils.User;

import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import static java.lang.Thread.sleep;

public class InfoDisplayFrame {

    JFrame frame;
    private JTable table;
    private long startTime = 1608040800;
    private int seconds = 1608040800;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InfoDisplayFrame window = new InfoDisplayFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public InfoDisplayFrame()throws Exception {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()throws Exception {
        frame = new JFrame();
        frame.setTitle("\u8003\u751F\u5217\u8868");
        frame.setBounds(0, 0, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel label = new JLabel("测试测试");
        label.setBounds(500, 19, 300, 40);
        label.setFont(new Font("幼圆",Font.PLAIN, 30));
        label.setForeground(new Color(125, 148, 92));
        frame.getContentPane().add(label);

        JLabel label2 = new JLabel("测试测试");
        label2.setBounds(0, 19, 300, 40);
        label2.setFont(new Font("幼圆",Font.PLAIN, 30));
        label2.setForeground(new Color(125, 148, 92));
        frame.getContentPane().add(label2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (seconds != 0){
                    try{
                        Calendar cal=Calendar.getInstance();
                        int h,m,s;
                        h=cal.get(Calendar.HOUR_OF_DAY);
                        m=cal.get(Calendar.MINUTE);
                        s=cal.get(Calendar.SECOND);
                        label.setText("当前时间: "+h+":"+m+":"+s);
                        seconds = (int)(startTime-cal.getTimeInMillis()/1000);
                        h = seconds/3600;
                        m = (seconds%3600)/60;
                        s = (seconds%3600)%60;
                        label2.setText("剩余时间: "+h+":"+m+":"+s);
                        sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                label.setVisible(false);
                label2.setText("剩余时间: "+0+":"+0+":"+0);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (seconds != 0){
                    try{
                        Check check = new Check();
                        ArrayList<User> users = check.getInfo();
                        String[] head = {"姓名","身份证号","准考证号","状态"};
                        String[][] infos = new String[1000][4];
                        for(int i=0;i<users.size();i++) {
                            infos[i][0] = users.get(i).getName();
                            infos[i][1] = users.get(i).getId();
                            infos[i][2] = users.get(i).getNum();
                            infos[i][3] = users.get(i).getIs_log();
                        }
                        setTable(infos, head);
                        sleep(5000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    private void setTable(String[][] infos,String[] head){
        table = new JTable(infos, head);
        table.setBounds(0, 50, 600, 400);
        //设置表头样式
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("幼圆",Font.PLAIN, 30));
        header.setForeground(new Color(125, 148, 92));
        header.setResizingAllowed(true);
        header.setReorderingAllowed(true);
        //设置行列属性
        table.setRowHeight(30);
        table.setFont(new Font("楷体",Font.PLAIN, 25));
        table.setEnabled(false);
        //添加滚动条
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(5,60,780,450);
        jsp.setVisible(true);

        frame.getContentPane().add(jsp);
    }
}
