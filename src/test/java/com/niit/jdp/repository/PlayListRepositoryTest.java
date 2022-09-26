package com.niit.jdp.repository;

import com.niit.jdp.model.PlayList;
import com.niit.jdp.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

class PlayListRepositoryTest {
    PlayListRepository playListRepository;
    PlayList playlist;
    DatabaseService databaseService;

    @BeforeEach
    void setUp() {
        playListRepository = new PlayListRepository();
        playlist = new PlayList();
        databaseService = new DatabaseService();

    }

    @AfterEach
    void tearDown() {
        playlist = null;
        databaseService = null;
        playListRepository = null;
    }

    @Test
    void getURLSuccess() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        String expectedOutput = "src/main/resources/songs/03-Homecoming.wav";
        String actualOutput = playListRepository.getURL(connection, 3);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }


}