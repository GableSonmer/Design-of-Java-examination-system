package res.utils;

import res.problem.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Read {
    String path = null;

    public Read(String path) {
        this.path = path;
    }

    /**
     * 得到单选题
     * @return
     * @throws IOException
     */
    public ArrayList get_singleProblems() throws IOException {
        ArrayList<SingleProblem> ans = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),
                Charset.forName("GBK")));
        String line;
        String start = "一、单选题（共20题，每题1分，共20分）";
        String end = "二、多选题（共20题，每题1分，共20分）";
        while ((line = reader.readLine()) != null) {
            if (line.equals(start)) {
                while (true) {
                    line = reader.readLine();
                    if (line.equals(end)) {
                        break;
                    }
                    if (line.charAt(0) >= '0' && line.charAt(0) <= '9') {
                        int len = 0;
                        String stem[] = new String[10];
                        String options[] = new String[4];
                        String answer = "";
                        int ans_index = -1;
                        while (true) {
                            int index = SingleMatch(line);
                            StringBuffer stringBuffer = new StringBuffer(line);
                            if (index != -1) {
                                //匹配到答案
                                ans_index = line.charAt(index) - 'A';
                                stringBuffer.deleteCharAt(index);
                            }
                            stem[len] = stringBuffer.toString();
                            len++;
                            line = reader.readLine();
                            if (line.charAt(0) == 'A') {
                                break;
                            }
                        }
                        options[0] = line;
                        for (int i = 1; i <= 3; i++) {
                            line = reader.readLine();
                            options[i] = line;
                        }
                        answer = options[ans_index];
                        SingleProblem p = new SingleProblem(stem, len, options, answer);
                        ans.add(p);
                    }
                }
            } else if (line.equals(end)) {
                break;
            }
        }
        return ans;
    }

    /**
     * 得到多选题
     * @return
     * @throws IOException
     */
    public ArrayList get_MultyProblems() throws IOException {
        ArrayList<MultyProblem> ans = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),
                Charset.forName("GBK")));
        String line;
        String start = "二、多选题（共20题，每题1分，共20分）";
        String end = "三、判断题（共10题，每题1分，共10分）";
        while ((line = reader.readLine()) != null) {
            if (line.equals(start)) {
                while (true) {
                    line = reader.readLine();
                    if (line.equals(end)) {
                        return ans;
                    }
                    if (line.charAt(0) >= '0' && line.charAt(0) <= '9') {
                        int len = 0;
                        String stem[] = new String[10];
                        String options[] = new String[4];
                        String answer[] = new String[4];
                        int ans_len = 0;
                        //读取题目
                        while (true) {
                            stem[len] = line;
                            len++;
                            line = reader.readLine();
                            if (line.charAt(0) == 'A') {
                                break;
                            }
                        }
                        options[0] = line;
                        for (int i = 1; i <= 3; i++) {
                            line = reader.readLine();
                            options[i] = line;
                        }
                        //匹配多选答案
                        String str = stem[0];
                        for (int i = 0; i < str.length(); i++) {
                            if (str.charAt(i) == '(' || str.charAt(i) == '（') {
                                //匹配空格
                                while (is_ABCD(str.charAt(i)) == false && i < str.length()) {
                                    i++;
                                }
                                //匹配ABCD
                                int index = i;
                                while (is_ABCD(str.charAt(i)) && i < str.length()) {
                                    answer[ans_len] = options[str.charAt(i) - 'A'];
                                    ans_len++;
                                    i++;
                                }
                                while (is_ABCD(str.charAt(i))) {
                                    answer[ans_len] = options[str.charAt(i) - 'A'];
                                    ans_len++;
                                    i++;
                                }
                                stem[0] = str.substring(0, index) + str.substring(index + ans_len);
                                break;
                            }
                        }
                        MultyProblem p = new MultyProblem(stem, len, options, answer, ans_len);
                        ans.add(p);
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 得到判断题
     * @return
     * @throws IOException
     */
    public ArrayList get_JudgeProblems() throws IOException {
        ArrayList<JudgeProblem> ans = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),
                Charset.forName("GBK")));
        String line;
        String start = "三、判断题（共10题，每题1分，共10分）";
        while ((line = reader.readLine()) != null) {
            if (line.equals(start)) {
                while ((line = reader.readLine()) != null & line.length() >= 2) {
                    if (line.charAt(0) >= '0' && line.charAt(0) <= '9') {
                        int len = 0;
                        String stem[] = new String[10];
                        String options[] = new String[4];
                        String answer = "";
                        while (true) {
                            stem[len] = line;
                            len++;
                            line = reader.readLine();
                            if (line.charAt(0) == 'A') {
                                break;
                            }
                        }
                        options[0] = line;
                        line = reader.readLine();
                        options[1] = line;
                        //匹配判断题答案
                        for (int j = 0; j < len; j++) {
                            String str = stem[j];
                            for (int i = 0; i < str.length(); i++) {
                                if (str.charAt(i) == '(' || str.charAt(i) == '（') {
                                    //匹配空格
                                    while (str.charAt(i) != '错' || str.charAt(i) != '正') {
                                        i++;
                                        if (i < str.length()) {
                                            break;
                                        }
                                    }
                                    //匹配ABCD
                                    int index = i;
                                    if (str.charAt(i) == '错') {
                                        answer = options[1];
                                    } else {
                                        answer = options[0];
                                    }
                                    stem[j] = str.substring(0, index) + str.substring(index + 2);
                                    break;
                                }
                            }
                        }

                        JudgeProblem p = new JudgeProblem(stem, len, options, answer);
                        ans.add(p);
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 判断是不是ABCD
     *
     * @param x
     * @return
     */
    private boolean is_ABCD(char x) {
        if (x == 'A' || x == 'B' || x == 'C' || x == 'D') {
            return true;
        }
        return false;
    }

    /**
     * 匹配单选答案
     *
     * @param content
     * @return
     */
    private int SingleMatch(String content) {
        /**
         * 匹配单选答案的位置
         * 失败就是-1
         */
        int index = -1;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '(' || content.charAt(i) == '（') {
                while (is_ABCD(content.charAt(i)) == false) {
                    i++;
                    if (i == content.length() - 1) {
                        return index;
                    }
                }
                if (is_ABCD(content.charAt(i))) {
                    index = i;
                    return index;
                }
            }
        }
        return index;
    }

}
