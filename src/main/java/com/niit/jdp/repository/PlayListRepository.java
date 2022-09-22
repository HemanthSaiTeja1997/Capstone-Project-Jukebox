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
        return playLists;
    }

    public void toDisplaySelectedSongFromPlaylist(Connection connection, String playlistsName) throws SQLException {
        //create SQL query to retrieve all the rows from the Song table
        String selectAllSongs = "SELECT `playlist_name`,`song_Id`,`playlist_url` FROM `jukebox`.`playlist` where (`playlist_name`=?);";
        //use the connection object to execute the query for selecting all songs
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectAllSongs)) {
            // 3. set the values of the query parameters
            preparedStatement.setString(1, playlistsName);
            //4. execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            // 5. check if the result set is empty
            while (resultSet.next()) {
                // 6. fetch the values of the current row from the result set
                int songId = resultSet.getInt("song_Id");
                String songName = resultSet.getString("playlist_name");
                String playlistURl = resultSet.getString("playlist_url");
                // 7. create a song object using the values fetched from the result set
                System.out.println("SongId : " + songId + "," + "PlaylistName : " + playlistsName + "," + "PlaylistURL : " + playlistURl);
            }
        }

    }
}