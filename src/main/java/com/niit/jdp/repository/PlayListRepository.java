/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.model.PlayList;
import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayListRepository {
    /**
     * It takes a `Connection` object, a `playListName` and a `Song` object as input and inserts the `Song` object into the
     * `playlist` table
     *
     * @param connection   The connection object that is used to connect to the database.
     * @param playListName The name of the playlist to which the song is to be added.
     * @param song         The song object that you want to add to the playlist
     * @return The number of rows affected by the query.
     */
    public boolean addSongDetails(Connection connection, String playListName, Song song) {
        // 1. write the query for inserting a new Song object into the `playlist` table
        int numberOfRowsAffected;
        try {

            String insertQuery = "INSERT INTO `jukebox`.`playlist` (`playlist_name`, `song_Id`," + " `playlist_url`, `songName`) VALUES (?,?,?,?);";
            // 2. create a statement object

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            // 3. set the values of the query parameters
            preparedStatement.setString(1, playListName);
            preparedStatement.setInt(2, song.getSongId());
            preparedStatement.setString(3, song.getUrl());
            preparedStatement.setString(4, song.getName());
            numberOfRowsAffected = preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return numberOfRowsAffected > 0;
    }

    /**
     * This function is used to display all the playlists in the database
     *
     * @param connection This is the connection object that is used to connect to the database.
     * @return A list of all the playlists in the database.
     */
    public List<PlayList> displayAllPlaylist(Connection connection) throws SQLException {
        List<PlayList> playLists = new ArrayList<>();
        //create SQL query to retrieve all the rows from the Song table
        String selectAllSongs = "SELECT * FROM `jukebox`.`playlist`;";
        //use the connection object to execute the query for selecting all songs
        ResultSet resultSet = connection.createStatement().executeQuery(selectAllSongs);
        //iterate over the result set and create a Song object for each row
        while (resultSet.next()) {
            int idOfPlaylist = resultSet.getInt("playlist_Id");
            String playListName = resultSet.getString("playlist_name");
            int playlistSongId = resultSet.getInt("song_Id");
            String urlOfPlaylist = resultSet.getString("playlist_url");
            String nameOfPlaylist = resultSet.getString("songName");
            //create a Song object using the values fetched from the result set
            PlayList newSong = new PlayList(idOfPlaylist, playListName, playlistSongId, urlOfPlaylist, nameOfPlaylist);
            playLists.add(newSong);
        }
        return playLists;
    }

    /**
     * This function is used to display the songs that are in a playlist
     *
     * @param connection    The connection object that is used to connect to the database.
     * @param playlistsName The name of the playlist that the user wants to see the songs of.
     */
    public void toDisplaySelectedSongFromPlaylist(Connection connection, String playlistsName) throws SQLException {
        //create SQL query to retrieve all the rows from the Song table
        String selectAllSongs = "SELECT `playlist_name`,`song_Id`,`songName` FROM `jukebox`.`playlist` where (`playlist_name`=?);";
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
                String playListSongName = resultSet.getString("playlist_name");
                String songNameOfPlay = resultSet.getString("songName");
                // 7. create a song object using the values fetched from the result set
                System.out.println(songId + "                " + songNameOfPlay);
            }
        }

    }


    /**
     * > This function takes a connection object and a song id as input and returns the url of the song with the given id
     *
     * @param connection the connection object that is used to connect to the database
     * @param songId     the id of the song whose URL we want to fetch
     * @return The URL of the song is being returned.
     */
    public String getURL(Connection connection, int songId) throws SQLException {
        // 1. write the query for selecting a song object from the `song` table
        String getQuery = "SELECT`playlist_url`From `jukebox`.`playlist` where (`song_Id`=?);";
        // 2. create a statement object
        PreparedStatement preparedStatement = connection.prepareStatement(getQuery);
        // 3. set the values of the query parameters
        preparedStatement.setInt(1, songId);
        //4. execute the query
        ResultSet resultSet = preparedStatement.executeQuery();
        String uRL = "";
        while (resultSet.next()) {
            // 6. fetch the values of the current row from the result set
            uRL = resultSet.getString("playlist_url");
            // 7. create a song object using the values fetched from the result set
        }
        return uRL;
    }
}