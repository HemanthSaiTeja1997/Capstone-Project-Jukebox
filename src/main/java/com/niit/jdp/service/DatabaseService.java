/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.service;

import java.sql.Connection;

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
}
