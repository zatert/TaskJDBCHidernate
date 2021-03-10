package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private  final String HOST = "jdbc:mysql://localhost:3306/dbtest";
    private  final String USERNAME = "root";
    private  final String PASSWORD = "root";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }
    public Util(Connection con){

    }
    public Util(){
        try{
//            Driver driver = new com.mysql.jdbc.Driver();
//            DriverManager.registerDriver(driver);
           this.connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
