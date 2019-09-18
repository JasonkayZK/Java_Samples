package annotation.chapter7.test.dbutilExample.noAnno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static String ip = "127.0.0.1";
    private static int port = 3306;
    private static String database = "test";
    private static String encoding = "UTF-8";
    private static String username = "root";
    private static String password = "admin";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return DriverManager.getConnection(url, username, password);
    }
    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }

}
