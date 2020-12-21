package res.utils;

public class User {
    private String name,id,num,is_log;

    public User(String name, String id, String num, String is_log) {
        this.name = name;
        this.id = id;
        this.num = num;
        this.is_log = is_log;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getIs_log() {
        return is_log;
    }

    public void setIs_log(String is_log) {
        this.is_log = is_log;
    }
}
