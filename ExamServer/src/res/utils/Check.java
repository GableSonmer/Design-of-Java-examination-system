package res.utils;

import java.sql.*;
import java.util.ArrayList;

public class Check {

    /**
     * 检查有无该用户信息
     *
     * @param id
     * @param num
     * @return
     * @throws Exception
     */
    public boolean checkStudent(String id, String num) throws Exception {
        //1.Driver注册
        Class.forName("com.mysql.jdbc.Driver");
        // "jdbc:mysql://服务器所在计算机的IP地址:服务器端口号/数据库名称"
        String url = "jdbc:mysql://localhost:3306/mydata?useSSL=false";
        //SQL命令
        String sql = "SELECT * FROM student where id = ? and no = ?";

        //2.建立一个连接通道
        Connection connection = DriverManager.getConnection(url, "root", "9090");

        //3.建立一个交通工具
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, num);

        //4.通过交通工具得到临时表
        ResultSet resultSet = preparedStatement.executeQuery();
        //5.判断结果
        int cnt = 0;
        while (resultSet.next()) {
            cnt++;
        }
        //6.关闭连接资源
        preparedStatement.close();
        connection.close();
        resultSet.close();
        //7.返回结果
        return cnt == 1;

    }

    /**
     * 切换为登录状态
     *
     * @param id
     * @throws Exception
     */
    public void updateStudent(String id) throws Exception {
        //1.Driver注册
        Class.forName("com.mysql.jdbc.Driver");
        // "jdbc:mysql://服务器所在计算机的IP地址:服务器端口号/数据库名称"
        String url = "jdbc:mysql://localhost:3306/mydata?useSSL=false";
        //SQL命令
        String sql = "UPDATE student SET is_log = 1 WHERE id = ?";

        //2.建立一个连接通道
        Connection connection = DriverManager.getConnection(url, "root", "9090");

        //3.建立一个交通工具
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);

        //4.推送命令
        preparedStatement.executeUpdate();

        //5.关闭资源
        preparedStatement.close();
        connection.close();
    }

    public ArrayList<User> getInfo() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        //1.Driver注册
        Class.forName("com.mysql.jdbc.Driver");
        // "jdbc:mysql://服务器所在计算机的IP地址:服务器端口号/数据库名称"
        String url = "jdbc:mysql://localhost:3306/mydata?useSSL=false";
        //SQL命令
        String sql = "SELECT * FROM student";

        //2.建立一个连接通道
        Connection connection = DriverManager.getConnection(url, "root", "9090");

        //3.建立一个交通工具
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //4.通过交通工具得到临时表
        ResultSet resultSet = preparedStatement.executeQuery();

        //5.存放结果
        while (resultSet.next()) {
            User user = new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4));
            if (user.getIs_log().equals("1")) {
                user.setIs_log("已登录");
            } else {
                user.setIs_log("未登录");
            }
            users.add(user);
        }
        preparedStatement.close();
        connection.close();
        //5.返回结果
        return users;
    }
}
