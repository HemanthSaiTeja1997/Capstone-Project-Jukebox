package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    public abstract void songs(Connection connection) throws SQLException;

    public boolean addSongDetails(Connection connection, T object) throws SQLException;

    public List<Song> getAllSongs(Connection connection) throws SQLException;

    public List<Song> searchByArtistAndSortByName(Connection connection, String artist) throws SQLException;

    public List<Song> searchByGenreAndSortByName(Connection connection, String genre) throws SQLException;

    public List<Song> searchByAlbumAndSortByName(Connection connection, String album) throws SQLException;
}
