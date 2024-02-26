package com.project.project2scenes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class db {

    private static Connection c;

    private static void setUpConnection() throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        System.out.println("Driver correttamente registrato.");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan", "root", "root");
    }

    public static void iud(String sql) throws Exception {
        if (c == null) {
            setUpConnection();
        }
        c.createStatement().executeUpdate(sql);
    }

    public static ResultSet search(String sql) throws Exception {
        if (c == null) {
            setUpConnection();
        }
        return c.createStatement().executeQuery(sql);
    }

    public static Connection getDBCon() throws Exception {
        if (c == null) {
            setUpConnection();
        }
        return c;
    }
}