package library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceUtil {
//    public static final String url="";
//    public static final String user=""; // после создания базы данныъ эти переменные  скорее всего уйдут в main
//    public static final String password="";
    public Connection getConnection(String url,String user,String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    public void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }

}
