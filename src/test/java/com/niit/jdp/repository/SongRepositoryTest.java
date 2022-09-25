package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

class SongRepositoryTest {
    SongRepository songRepository;
    DatabaseService databaseService;

    @BeforeEach
    void setUp() {
        songRepository = new SongRepository();
        databaseService = new DatabaseService();
    }

    @AfterEach
    void tearDown() {
        songRepository = null;
        databaseService = null;
    }

    @Test
    void getAllSongs() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        List<Song> actualResult = songRepository.getAllSongs(connection);
        List<Song> expectedResult = songRepository.getAllSongs(connection);
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    void searchByArtistAndSortByName() {
    }

    @Test
    void searchByGenreAndSortByName() {
    }

    @Test
    void searchByAlbumAndSortByName() {
    }
}