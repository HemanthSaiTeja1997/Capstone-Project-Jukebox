/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {
    public List<Song> getAllSongs(Connection connection) throws SQLException {
        List<Song> songList = new ArrayList<>();
        //create SQL query to retrieve all the rows from the Song table
        String selectAllSongs = "SELECT * FROM `jukebox`.`song`;";
        //use the connection object to execute the query for selecting all songs
        ResultSet resultSet = connection.createStatement().executeQuery(selectAllSongs);


        return null;
    }
}
