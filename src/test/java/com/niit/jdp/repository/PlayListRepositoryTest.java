package com.niit.jdp.repository;

import com.niit.jdp.model.PlayList;
import com.niit.jdp.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    void toDisplaySelectedSongFromPlaylist() {
    }

    @Test
    void getURL() {
    }
}