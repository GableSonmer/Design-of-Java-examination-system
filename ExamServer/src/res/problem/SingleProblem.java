package res.problem;

import java.io.Serializable;

public class SingleProblem implements Serializable {

    private static final long serialVersionUID = 7949083161806469758L;

    public SingleProblem(String stem[], int len, String options[], String answer) {
        this.stem = stem;
        this.len = len;
        this.options = options;
        this.answer = answer;
    }

    private String stem[] = new String[10];//题干
    private int len = 0;//题干所占长度
    private String options[] = new String[4];//选项
    private String answer = null;

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
