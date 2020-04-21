package library.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;


public class DataSourceUtil {


    private static final String url="jdbc:mysql://localhost:3306/library?serverTimezone=Europe/Moscow";
    private static final String user="root";
    private static final String password="1212";
    public static Connection getConnection() throws SQLException {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Connection succesfull!");
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    public static void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }

}
