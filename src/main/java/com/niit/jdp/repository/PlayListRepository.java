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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class PlayListRepository implements Repository<PlayList> {
    List<Song> song = new ArrayList<Song>();

    @Override
    public boolean addSongDetails(Connection connection, PlayList playList) throws SQLException {
        // 1. write the query for inserting a new Song object into the `playlist` table
        String insertQuery = "INSERT INTO `jukebox`.`playlist` (`playlistId`, `playlistName`, `song_Id`) VALUES (?,?,?);";
        // 2. create a statement object
        int numberOfRowsAffected;
        String songID = song.toString().trim().replace("\\[\\]", "");
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // 3. set the values of the query parameters
            preparedStatement.setInt(1, playList.getPlayListId());
            preparedStatement.setString(2, playList.getPlayListName());
            preparedStatement.setString(3, songID);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    @Override
    public List<Song> getAllSongs(Connection connection) throws SQLException {
        return null;
    }
}
