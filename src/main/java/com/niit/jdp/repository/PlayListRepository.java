/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.model.PlayList;
import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class PlayListRepository implements Repository<PlayList> {

    @Override
    public boolean addSongDetails(Connection connection, PlayList object) throws SQLException {

        return false;
    }

    @Override
    public List<Song> getAllSongs(Connection connection) throws SQLException {
        return null;
    }
}
