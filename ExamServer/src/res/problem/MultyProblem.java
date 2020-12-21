package res.problem;

import java.io.Serializable;

public class MultyProblem  implements Serializable {
    private static final long serialVersionUID = -1557810174460218386L;

    public MultyProblem() {
    }
    private String stem[] = new String[10];//题干
    private int len = 0;//题干所占长度
    private String options[] = new String[4];//选项
    private String answer[] = new String[4];
    private int answer_len;

    public int getAnswer_len() {
        return answer_len;
    }

    public void setAnswer_len(int answer_len) {
        this.answer_len = answer_len;
    }

    public MultyProblem(String[] stem, int len, String[] options, String[] answer, int answer_len) {
        this.stem = stem;
        this.len = len;
        this.options = options;
        this.answer = answer;
        this.answer_len = answer_len;
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

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }
}
