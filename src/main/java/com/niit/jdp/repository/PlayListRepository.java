/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.model.PlayList;
import com.niit.jdp.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayListRepository {
    public boolean addSongDetails(Connection connection, String playListName, Song song) throws SQLException {
        // 1. write the query for inserting a new Song object into the `playlist` table
        int numberOfRowsAffected = 0;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from playlist");

            String insertQuery = "INSERT INTO `jukebox`.`playlist` (`playlist_name`, `song_Id`," +
                    " `playlist_url`) VALUES (?,?,?);";
            // 2. create a statement object

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            // 3. set the values of the query parameters
            preparedStatement.setString(1, playListName);
            preparedStatement.setInt(2, song.getSongId());
            preparedStatement.setString(3, song.getUrl());
            //  preparedStatement.set(3, song1);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return numberOfRowsAffected > 0;
    }

    public List<PlayList> displayAllPlaylist(Connection connection) throws SQLException {
        List<PlayList> playLists = new ArrayList<>();
        //create SQL query to retrieve all the rows from the Song table
        String selectAllSongs = "SELECT * FROM `jukebox`.`playlist`;";
        //use the connection object to execute the query for selecting all songs
        ResultSet resultSet = connection.createStatement().executeQuery(selectAllSongs);
        //iterate over the result set and create a Song object for each row
        while (resultSet.next()) {
            int IdOfPlaylist = resultSet.getInt("playlist_Id");
            String playListName = resultSet.getString("playlist_name");
            int playlistSongId = resultSet.getInt("song_Id");
            String urlOfPlaylist = resultSet.getString("playlist_url");
            //create a Song object using the values fetched from the result set
            PlayList newSong = new PlayList(IdOfPlaylist, playListName, playlistSongId, urlOfPlaylist);
            playLists.add(newSong);
        }
        return songList;
    }


}