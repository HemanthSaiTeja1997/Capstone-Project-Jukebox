/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    //a method that can connect to Database
    // a private fields to store the reference of connection object
    private static final String URL = "jdbc:mysql://localhost:3306/jukebox";
    private static final String PASSWORD = "Hemanth@831";
    private static final String USERNAME = "root";
    private Connection connection;

    public DatabaseService() {
        this.connection = null;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection != null;
    }

    public void printConnectionStatus() {
        if (connection != null) {
            System.out.println("\u001B[32m Connected to the database.\u001B[0m");
        } else {
            System.err.println("Not connected to the database");

        }
    }
}
