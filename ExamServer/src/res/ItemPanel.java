package res;

import javax.swing.*;
import java.awt.*;

public class ItemPanel extends JPanel {
    private String name;
    private String studentID;
    private String examNum;
    private String adress;
    private String status;
    private JLabel[] labels = new JLabel[6];

    public ItemPanel(String name, String studentID, String examNum, String adress, String status) {
        this.name = name;
        this.studentID = studentID;
        this.examNum = examNum;
        this.adress = adress;
        this.status = status;
        init();
    }
    private void init(){
        for(int i=1;i<=5;i++){
            labels[i] = new JLabel();
            labels[i].setBounds(100*(i-1),0,100,30);
            labels[i].setFont(new Font("楷体", Font.PLAIN, 15));
            add(labels[i]);
        }
        labels[1].setText(name);
        labels[2].setText(studentID);
        labels[3].setText(examNum);
        labels[4].setText(adress);
        labels[5].setText(status);
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getExamNum() {
        return examNum;
    }

    public void setExamNum(String examNum) {
        this.examNum = examNum;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
