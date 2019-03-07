package com.practice.database;

import java.sql.*;

public class DBConnection {
    String url = "jdbc:mysql://localhost:3306/javaPractice";
    String userName = "lynda";
    String passWord = "lynda";

    Connection connection = null;

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, passWord);
            System.out.println("okk conn");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("no conn");
        }

    }


    public PreparedStatement getPreparedStatement(String query) throws SQLException{
       return connection.prepareStatement(query);
   }
}
