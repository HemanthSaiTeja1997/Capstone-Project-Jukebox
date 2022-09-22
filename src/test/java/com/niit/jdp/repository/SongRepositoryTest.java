package com.niit.jdp.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SongRepositoryTest {
    SongRepository songRepository;

    @BeforeEach
    void setUp() {
        songRepository = new SongRepository();
    }

    @AfterEach
    void tearDown() {
        songRepository = null;
    }

    @Test
    void getAllSongs() {
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