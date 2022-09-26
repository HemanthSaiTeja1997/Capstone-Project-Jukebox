package com.niit.jdp.repository;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface FunctionalRepository {
    public void toDisplaySelectedSongFromPlaylist(Connection connection, String playlistsName) throws SQLException;
}
