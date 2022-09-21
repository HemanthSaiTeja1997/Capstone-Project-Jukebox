/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {
    List<Song> sortedSongs = new ArrayList<>();

    public List<Song> getAllSongs(Connection connection) throws SQLException {
        List<Song> songList = new ArrayList<>();
        //create SQL query to retrieve all the rows from the Song table
        String selectAllSongs = "SELECT * FROM `jukebox`.`song`;";
        //use the connection object to execute the query for selecting all songs
        ResultSet resultSet = connection.createStatement().executeQuery(selectAllSongs);
        //iterate over the result set and create a Song object for each row
        while (resultSet.next()) {
            int songId = resultSet.getInt("song_Id");
            String songName = resultSet.getString("name");
            String album = resultSet.getString("album");
            String artistName = resultSet.getString("artist_name");
            String gener = resultSet.getString("genre");
            String duration = resultSet.getString("duration");
            String uRL = resultSet.getString("url");
            //create a Song object using the values fetched from the result set
            Song newSong = new Song(songId, songName, album, artistName, gener, duration, uRL);
            songList.add(newSong);
        }

        return songList;
    }

    public boolean addSongDetails(Connection connection, Song song) throws SQLException {
        // 1. write the query for inserting a new Song object into the `song` table
        String insertQuery = "INSERT INTO `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `duration`,"
                + " `url`) VALUES (?,?,?,?,?,?,?);";
        // 2. create a statement object
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // 3. set the values of the query parameters
            preparedStatement.setInt(1, song.getSongId());
            preparedStatement.setString(2, song.getName());
            preparedStatement.setString(3, song.getAlbum());
            preparedStatement.setString(4, song.getArtist());
            preparedStatement.setString(5, song.getGenre());
            preparedStatement.setString(6, song.getDuration());
            preparedStatement.setString(7, song.getUrl());
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    public Song searchAndSortByArtist(Connection connection, String artist) {
        // 1. write the query for selecting a song object from the `song` table
        String searchQuery = "SELECT*From `jukebox`.`song` where (`artist`=?);";
        Song song = new Song();
        // 2. create a statement object
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(searchQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }
}
