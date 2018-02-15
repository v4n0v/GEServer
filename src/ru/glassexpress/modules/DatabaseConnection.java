package ru.glassexpress.modules;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private Connection conn;
    private Driver driver;
    String db_name = "glass_express_db";
    String username = "root";
    String pass = "12345";


    public void connect() {

        //String URL = "jdbc: mysql://mysql:3306/";
        String URL = "jdbc:mysql://localhost:3306/";


        try {
            driver = new FabricMySQLDriver();
            Log2File.writeLog(Events.DRIVER_CREATE_OK);
        } catch (SQLException e) {

            Log2File.writeLog(Events.DRIVER_CREATE_ERROR);
            return;
        }

        try {
            DriverManager.registerDriver(driver);
            Log2File.writeLog(Events.DRIVER_REGISTRATION_OK);
        } catch (SQLException e) {


            Log2File.writeLog(Events.DRIVER_REGISTRATION_ERROR);
            return;
        }

        try {
            conn = DriverManager.getConnection(URL + db_name, username, pass);

            Log2File.writeLog(Events.DB_CONNECTION_OK+"База: "+db_name+"\nusername = "+username+"\n");

        } catch (SQLException e) {

            Log2File.writeLog( Events.DB_CONNECTION_ERROR+"База: "+db_name+"\nusername = "+username+"\n");
            return;
        }


    }

    public void disconnect() {
        if (conn != null) {
            try {
                conn.close();

                Log2File.writeLog( Events.DB_DISCONNECTION_OK+"База: "+db_name+"\n");
            } catch (SQLException e) {

                Log2File.writeLog( Events.DB_DISCONNECTION_ERROR+"База: "+db_name+"\n");
                e.printStackTrace();
            }
        }
    }
}
