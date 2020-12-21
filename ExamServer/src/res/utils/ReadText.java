package res.utils;

import java.io.IOException;
import java.util.ArrayList;

public class ReadText {
    private String path = null;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ReadText(String path) {
        this.path = path;
    }

    public ArrayList getSingleProblem() throws IOException {
        Read read = new Read(this.getPath());
        return read.get_singleProblems();
    }

    public ArrayList getMultyProblem() throws IOException {
        Read read = new Read(this.getPath());
        return read.get_MultyProblems();
    }

    public ArrayList getJudgeProblem() throws IOException {
        Read read = new Read(this.getPath());
        return read.get_JudgeProblems();
    }
}
