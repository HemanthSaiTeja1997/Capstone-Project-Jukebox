package com.niit.jdp.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    public abstract void songs(Connection connection) throws SQLException;

    public boolean addSongDetails(Connection connection, T object) throws SQLException;

    public List<T> getAllSongs(Connection connection) throws SQLException;

    public List<T> searchByArtistAndSortByName(Connection connection, String artist) throws SQLException;

    public List<T> searchByGenreAndSortByName(Connection connection, String genre) throws SQLException;

    public List<T> searchByAlbumAndSortByName(Connection connection, String album) throws SQLException;
}
