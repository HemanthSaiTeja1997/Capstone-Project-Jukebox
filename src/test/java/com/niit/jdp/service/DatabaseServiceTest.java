package com.niit.jdp.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseServiceTest {
    private static final String URL = "jdbc:mysql://localhost:3306/jukebox";
    private static final String PASSWORD = "Hemanth@831";
    private static final String USERNAME = "root";

    DatabaseService databaseService;
    private Connection connection;

    String printConnectionStatus1() {
        String expectedResult = "";
        if (connection != null) {
            System.out.println("\u001B[32m Connected to the database.\u001B[0m");
            expectedResult = "Connected to the database";
        } else {
            System.err.println("Not connected to the database");
            expectedResult = "Not connected to the database";
        }
        return expectedResult;
    }

    @BeforeEach
    void setUp() throws SQLException {
        databaseService = new DatabaseService();
    }

    @AfterEach
    void tearDown() {
        databaseService = null;
    }

    @Test
    void connect() throws SQLException, ClassNotFoundException {
        boolean expectedResult = true;
        boolean actualResult = databaseService.connect();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void connectFailure() throws SQLException, ClassNotFoundException {
        boolean unexpectedResult = false;
        boolean actualResult = databaseService.connect();
        Assertions.assertNotEquals(unexpectedResult, actualResult);
    }

    @Test
    void printConnectionStatus() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        databaseService.connect();
        String expectedResult = "Connected to the database";
        String actualResult = printConnectionStatus1();
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    void printConnectionStatusFailure() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        String expectedResult = "Not connected to the database";
        String actualResult = printConnectionStatus1();
        Assertions.assertEquals(expectedResult, actualResult);

    }

}