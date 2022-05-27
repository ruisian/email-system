package com.email.app;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public java.sql.Connection createConnection() {
        java.sql.Connection conn = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/email_service";
            String username = "postgres"; //your my sql username here
            String password = "postgres"; //your mysql password here

            // Class.forName("org.postgresql.driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void connect() {
        DBConnection connect = new DBConnection();
        connect.createConnection();
    }

}
