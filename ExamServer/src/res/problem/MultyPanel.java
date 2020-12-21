package res.problem;

//import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class MultyPanel extends JPanel implements Serializable {
    private static final long serialVersionUID = -1387138010160450807L;
    private MultyProblem problem;
    private boolean flag = true;
    private boolean index[] = new boolean[4];
    JCheckBox check[] = new JCheckBox[4];

    public MultyPanel(MultyProblem p) {
        problem = p;
        init();
    }

    private void init() {
        for (int i = 0; i < 4; i++) {
            index[i] = false;
        }
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
        //添加选项
        for (int i = 0; i < 4; i++) {
            check[i] = new JCheckBox();
            check[i].setText(problem.getOptions()[i]);
            check[i].setBounds(x, y, width, height);
            check[i].setFont(new Font("微软雅黑", Font.PLAIN, 20));
            y += spacing;
            add(check[i]);
        }

        for (int i = 0; i < 4; i++) {
            index[i] = false;
            for (int j = 0; j < problem.getAnswer_len(); j++) {
                if (problem.getOptions()[i].equals(problem.getAnswer()[j])) {
                    index[i] = true;
                }
            }
        }
    }

    public boolean isFlag() {
        for (int i = 0; i < 3; i++) {
            if (index[i]) {
                if (!check[i].isSelected()) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    public ArrayList<Integer> getSelectedOption() {
        //答案按钮标号, 用于回传答案
        ArrayList<Integer> ansIndex = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (check[i].isSelected()) {
                ansIndex.add(i);
            }
        }
        return ansIndex;
    }
}
