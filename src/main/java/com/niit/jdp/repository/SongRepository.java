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
import java.util.Comparator;
import java.util.List;

public class SongRepository {


    List<Song> sortedsong = new ArrayList<>();

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
            String artistName = resultSet.getString("artist");
            String gener = resultSet.getString("genre");
            String duration = resultSet.getString("duration");
            String uRL = resultSet.getString("url");
            //create a Song object using the values fetched from the result set
            Song newSong = new Song(songId, songName, album, artistName, gener, duration, uRL);
            songList.add(newSong);
        }

        return songList;
    }

    public List<Song> searchByArtistAndSortByName(Connection connection, String artist) throws SQLException {
        // 1. write the query for selecting a song object from the `song` table
        String searchQuery = "SELECT*From `jukebox`.`song` where (`artist`=?);";
        List<Song> songList = new ArrayList<>();
        // 2. create a statement object
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            // 3. set the values of the query parameters
            preparedStatement.setString(1, artist);
            //4. execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            // 5. check if the result set is empty
            while (resultSet.next()) {
                // 6. fetch the values of the current row from the result set
                int songId = resultSet.getInt("song_Id");
                String songName = resultSet.getString("name");
                String album = resultSet.getString("album");
                String artistName = resultSet.getString("artist");
                String gener = resultSet.getString("genre");
                String duration = resultSet.getString("duration");
                String uRL = resultSet.getString("url");
                // 7. create a song object using the values fetched from the result set
                Song song = new Song(songId, songName, album, artistName, gener, duration, uRL);
                songList.add(song);
                songList.sort(Comparator.comparing(Song::getName));
            }

            return songList;
        }
    }

    public List<Song> searchByGenreAndSortByName() {
        // 1. write the query for selecting a song object from the `song` table
        String searchQuery = "SELECT*From `jukebox`.`song` where (`genre`=?);";
        List<Song> songList = new ArrayList<>();

        return null;
    }

}
