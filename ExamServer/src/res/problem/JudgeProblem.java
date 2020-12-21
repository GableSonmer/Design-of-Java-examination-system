package res.problem;

import java.io.Serializable;

public class JudgeProblem implements Serializable {

    private static final long serialVersionUID = 3481036184661841973L;
    private String stem[] = new String[10];//题干
    private int len = 0;//题干所占长度
    private String options[] = new String[2];//选项
    private String answer;
    public JudgeProblem() {
    }

    public JudgeProblem(String[] stem, int len, String[] options, String answer) {
        this.stem = stem;
        this.len = len;
        this.options = options;
        this.answer = answer;
    }

    public String[] getStem() {
        return stem;
    }

    public void setStem(String[] stem) {
        this.stem = stem;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
