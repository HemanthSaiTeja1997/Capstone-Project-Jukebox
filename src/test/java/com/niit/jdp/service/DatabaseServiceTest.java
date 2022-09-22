package com.niit.jdp.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

class DatabaseServiceTest {
    private static final String URL = "jdbc:mysql://localhost:3306/jukebox";
    private static final String PASSWORD = "Hemanth@831";
    private static final String USERNAME = "root";
    DatabaseService databaseService;
    private Connection connection;


    @BeforeEach
    void setUp() {
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
    void printConnectionStatus() {
    }
}