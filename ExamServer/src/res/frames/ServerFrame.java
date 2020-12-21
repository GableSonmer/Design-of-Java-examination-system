package res.frames;

import java.awt.Color;
import java.awt.FileDialog;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class ServerFrame {

    public JFrame frame;
    //试卷标题文本框
    private JTextField paperTitleTextField;
    //试卷满分文本框
    private JTextField allScoreTextFiled;
    //考试时间文本框
    private JTextField timeTextFiled;
    //选择试卷文本框
    private JTextField choosePaperTextField;
    //单选题题数文本框
    private JTextField numberOfSingleTextFiled;
    //单选题分值文本框
    private JTextField scoreOfSingleTextFiled;
    //多选题题数文本框
    private JTextField numberOfMultyTextFiled;
    //多选题分值文本框
    private JTextField scoreOfMultyTextFiled;
    //判断题题数文本框
    private JTextField numberOfJudgeTextFiled;
    //判断题分值文本框
    private JTextField scoreOfJudgeTextFiled;

    public File paper;

    /**
     * Create the application.
     */
    public ServerFrame() {
        initialize();
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

        //提交
        JButton sumbit = new JButton("\u4FDD\u5B58\u5E76\u53D1\u653E");
        sumbit.setBounds(323, 462, 130, 60);
        sumbit.setForeground(new Color(125, 148, 92));
        sumbit.setFont(new Font("楷体", Font.BOLD, 18));
        frame.getContentPane().add(sumbit);

        //试卷标题
        JLabel paperTitle = new JLabel("\u8BD5\u5377\u6807\u9898:");
        paperTitle.setFont(new Font("楷体", Font.BOLD, 18));
        paperTitle.setBounds(160, 20, 100, 30);
        frame.getContentPane().add(paperTitle);

        //选择试卷
        JLabel chooseLabel = new JLabel("\u9009\u62E9\u8BD5\u5377:");
        chooseLabel.setFont(new Font("楷体", Font.BOLD, 18));
        chooseLabel.setBounds(160, 60, 100, 30);
        frame.getContentPane().add(chooseLabel);

        //试卷满分
        JLabel scorelabel = new JLabel("\u8BD5\u5377\u6EE1\u5206:");
        scorelabel.setFont(new Font("楷体", Font.BOLD, 18));
        scorelabel.setBounds(160, 100, 100, 30);
        frame.getContentPane().add(scorelabel);

        //试卷标题文本框
        paperTitleTextField = new JTextField();
        paperTitleTextField.setBounds(260, 20, 413, 30);
        paperTitleTextField.setColumns(10);
        paperTitleTextField.setFont(new Font("宋体", Font.PLAIN, 15));
        frame.getContentPane().add(this.paperTitleTextField);

        //试卷满分文本框
        allScoreTextFiled = new JTextField();
        allScoreTextFiled.setBounds(260, 100, 100, 30);
        allScoreTextFiled.setColumns(10);
        allScoreTextFiled.setFont(new Font("宋体", Font.PLAIN, 15));
        frame.getContentPane().add(allScoreTextFiled);

        //考试时长分钟
        JLabel timelabel = new JLabel("\u8003\u8BD5\u65F6\u957F(\u5206\u949F):");
        timelabel.setFont(new Font("楷体", Font.BOLD, 18));
        timelabel.setBounds(420, 100, 163, 30);
        frame.getContentPane().add(timelabel);

        //考试时长文本框
        timeTextFiled = new JTextField();
        timeTextFiled.setBounds(585, 100, 86, 30);
        frame.getContentPane().add(timeTextFiled);
        timeTextFiled.setColumns(10);
        timeTextFiled.setFont(new Font("宋体", Font.PLAIN, 15));
        //选择试卷文本框
        choosePaperTextField = new JTextField();
        choosePaperTextField.setBounds(260, 60, 367, 30);
        frame.getContentPane().add(choosePaperTextField);
        choosePaperTextField.setColumns(10);
        choosePaperTextField.setFont(new Font("宋体", Font.PLAIN, 15));

        //…
        JButton open = new JButton("+");
        open.setBounds(635, 60, 29, 27);
        frame.getContentPane().add(open);

        //单选题
        JLabel lblNewLabel = new JLabel("\u5355\u9009\u9898");
        lblNewLabel.setFont(new Font("楷体", Font.BOLD, 17));
        lblNewLabel.setBounds(163, 148, 72, 18);
        frame.getContentPane().add(lblNewLabel);

        numberOfSingleTextFiled = new JTextField();
        numberOfSingleTextFiled.setBounds(230, 179, 86, 22);
        frame.getContentPane().add(numberOfSingleTextFiled);
        numberOfSingleTextFiled.setColumns(10);
        numberOfSingleTextFiled.setFont(new Font("宋体", Font.PLAIN, 15));

        scoreOfSingleTextFiled = new JTextField();
        scoreOfSingleTextFiled.setBounds(230, 204, 86, 22);
        frame.getContentPane().add(scoreOfSingleTextFiled);
        scoreOfSingleTextFiled.setColumns(10);
        scoreOfSingleTextFiled.setFont(new Font("宋体", Font.PLAIN, 15));

        JLabel label = new JLabel("\u9898\u6570:");
        label.setFont(new Font("楷体", Font.PLAIN, 15));
        label.setBounds(168, 179, 72, 18);
        frame.getContentPane().add(label);

        JLabel label_1 = new JLabel("\u5206\u503C:");
        label_1.setFont(new Font("楷体", Font.PLAIN, 15));
        label_1.setBounds(168, 204, 72, 18);
        frame.getContentPane().add(label_1);

        //多选题
        JLabel lblNewLabel_3 = new JLabel("\u591A\u9009\u9898");
        lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 17));
        lblNewLabel_3.setBounds(163, 241, 72, 18);
        frame.getContentPane().add(lblNewLabel_3);

        numberOfMultyTextFiled = new JTextField();
        numberOfMultyTextFiled.setBounds(230, 273, 86, 24);
        frame.getContentPane().add(numberOfMultyTextFiled);
        numberOfMultyTextFiled.setColumns(10);
        numberOfMultyTextFiled.setFont(new Font("宋体", Font.PLAIN, 15));

        scoreOfMultyTextFiled = new JTextField();
        scoreOfMultyTextFiled.setBounds(230, 301, 86, 24);
        frame.getContentPane().add(scoreOfMultyTextFiled);
        scoreOfMultyTextFiled.setColumns(10);
        scoreOfMultyTextFiled.setFont(new Font("宋体", Font.PLAIN, 15));

        JLabel label_2 = new JLabel("\u9898\u6570:");
        label_2.setFont(new Font("楷体", Font.PLAIN, 15));
        label_2.setBounds(168, 276, 72, 18);
        frame.getContentPane().add(label_2);

        JLabel label_1_1 = new JLabel("\u5206\u503C:");
        label_1_1.setFont(new Font("楷体", Font.PLAIN, 15));
        label_1_1.setBounds(168, 301, 72, 18);
        frame.getContentPane().add(label_1_1);

        //判断题
        JLabel lblNewLabel_6 = new JLabel("\u5224\u65AD\u9898");
        lblNewLabel_6.setFont(new Font("楷体", Font.BOLD, 17));
        lblNewLabel_6.setBounds(163, 349, 72, 18);
        frame.getContentPane().add(lblNewLabel_6);

        numberOfJudgeTextFiled = new JTextField();
        numberOfJudgeTextFiled.setBounds(230, 385, 86, 22);
        frame.getContentPane().add(numberOfJudgeTextFiled);
        numberOfJudgeTextFiled.setColumns(10);
        numberOfJudgeTextFiled.setFont(new Font("宋体", Font.PLAIN, 15));

        scoreOfJudgeTextFiled = new JTextField();
        scoreOfJudgeTextFiled.setBounds(230, 410, 86, 22);
        frame.getContentPane().add(scoreOfJudgeTextFiled);
        scoreOfJudgeTextFiled.setColumns(10);
        scoreOfJudgeTextFiled.setFont(new Font("宋体", Font.PLAIN, 15));

        JLabel label_3 = new JLabel("\u9898\u6570:");
        label_3.setFont(new Font("楷体", Font.PLAIN, 15));
        label_3.setBounds(168, 385, 72, 18);
        frame.getContentPane().add(label_3);

        JLabel label_1_2 = new JLabel("\u5206\u503C:");
        label_1_2.setFont(new Font("楷体", Font.PLAIN, 15));
        label_1_2.setBounds(168, 410, 72, 18);
        frame.getContentPane().add(label_1_2);

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog(frame, "Open File", FileDialog.LOAD);
                fd.setVisible(true);
                if (fd.getFile() != null) {
                    File file = new File(fd.getDirectory() + fd.getFile());
                    paper = file;
                    setTestPaperInformation(file.getName());
                }
                fd.dispose();
            }
        });
        sumbit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //显示考生是否登录页面
                frame.dispose();
                try{
                    InfoDisplayFrame window = new InfoDisplayFrame();
                    window.frame.setVisible(true);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
    }

    /**
     * 设置试卷信息
     *
     * @param fileName
     */
    private void setTestPaperInformation(String fileName) {
        paperTitleTextField.setText(fileName);
        paperTitleTextField.setEnabled(false);
        choosePaperTextField.setText(fileName);
        choosePaperTextField.setEnabled(false);
        allScoreTextFiled.setText("100");
        allScoreTextFiled.setEnabled(false);
        numberOfSingleTextFiled.setText("20");
        scoreOfSingleTextFiled.setText("40");
        numberOfMultyTextFiled.setText("20");
        scoreOfMultyTextFiled.setText("40");
        numberOfJudgeTextFiled.setText("10");
        scoreOfJudgeTextFiled.setText("20");
        numberOfJudgeTextFiled.setEnabled(false);
        numberOfMultyTextFiled.setEnabled(false);
        numberOfSingleTextFiled.setEnabled(false);
        scoreOfJudgeTextFiled.setEnabled(false);
        scoreOfMultyTextFiled.setEnabled(false);
        scoreOfSingleTextFiled.setEnabled(false);
        allScoreTextFiled.setText("100");
        allScoreTextFiled.setEnabled(false);
        timeTextFiled.setText("100");
        timeTextFiled.setEnabled(false);
    }
}
