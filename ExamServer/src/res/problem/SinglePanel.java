package res.problem;

//import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class SinglePanel extends JPanel implements Serializable {
    private static final long serialVersionUID = -1068356902031211203L;
    private SingleProblem problem;
    private int index;//答案按钮标号
    private int selectedIndex = -1;//考试选择的选项
    private boolean flag = false;
    JRadioButton radioButton[] = new JRadioButton[4];

    public SinglePanel(SingleProblem p) {
        problem = p;
        init();
    }

    private void init() {
        //panel基本属性
        setBounds(0, 25, 1000, 500);
        setLayout(null);
        //添加控件,相对坐标
        int y = 20, x = 0, width = 1000, height = 30, spacing = 40;
        ButtonGroup answerGroup = new ButtonGroup();
        //添加题干
        for (int i = 0; i < problem.getLen(); i++) {
            JLabel label = new JLabel();
            label.setText(problem.getStem()[i]);
            label.setBounds(x, y, width, height);
            y += spacing;
            label.setFont(new Font("宋体", Font.BOLD, 23));
            add(label);
        }
        ButtonGroup group = new ButtonGroup();
        //添加选项
        for (int i = 0; i < 4; i++) {
            if (problem.getOptions()[i].equals(problem.getAnswer())) {
                index = i;
            }
            radioButton[i] = new JRadioButton();
            radioButton[i].setText(problem.getOptions()[i]);
            radioButton[i].setBounds(x, y, width, height);
            radioButton[i].setFont(new Font("微软雅黑", Font.PLAIN, 20));
            y += spacing;
            group.add(radioButton[i]);
            add(radioButton[i]);
        }
        radioButton[index].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedIndex = index;
                flag = true;
            }
        });
    }

    public boolean isFlag() {
        return flag;
    }

    public ArrayList<Integer> getSelectedOption() {
        //答案按钮标号, 用于回传答案
        ArrayList<Integer> ansIndex = new ArrayList<>();
        for(int i =0 ;i<4;i++){
            if(radioButton[i].isSelected()){
                ansIndex.add(i);
                break;
            }
        }
        return ansIndex;
    }
}
