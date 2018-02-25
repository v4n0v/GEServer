package ru.glassexpress.modules;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnect {

//    static Connection connection=null;
//
//    static {
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String jdbcUrl = "jdbc:mysql://localhost:3306/glass_express_db";
//            String user = "root";
//            String pass = "12345";
//
//            connection = DriverManager.getConnection(jdbcUrl, user, pass);
//
//
//          //  connection.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    public static Connection getConnection( )  {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        String jdbcUrl = "jdbc:mysql://localhost:3306/glass_express_db";
        String user = "root";
        String pass = "12345";

        return DriverManager.getConnection(jdbcUrl, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
