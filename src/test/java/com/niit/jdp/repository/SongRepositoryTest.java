package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

class SongRepositoryTest {
    SongRepository songRepository;
    Song song;
    DatabaseService databaseService;

    @BeforeEach
    void setUp() {
        songRepository = new SongRepository();
        databaseService = new DatabaseService();
        song = new Song();
    }

    @AfterEach
    void tearDown() {
        songRepository = null;
        databaseService = null;
        song = null;
    }

    @Test
    void getSongByIdSuccess() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        Song actualOutput = songRepository.getSongById(connection, song.getSongId());
        Song expectedOutput = songRepository.getSongById(connection, actualOutput.getSongId());
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void getSongByIdFailure() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        Song actualOutput = null;
        Song expectedOutput = songRepository.getSongById(connection, song.getSongId());
        Assertions.assertNotEquals(expectedOutput, actualOutput);
    }

    @Test
    void getURLSuccess() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        String expectedOutput = "src/main/resources/songs/01-Shippuuden.wav";
        String actualOutput = songRepository.getURL(connection, 1);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void getURLFailure() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        String expectedOutput = "src/main/resources/songs/01-Shippuuden";
        String actualOutput = songRepository.getURL(connection, 1);
        Assertions.assertNotEquals(expectedOutput, actualOutput);
    }
}