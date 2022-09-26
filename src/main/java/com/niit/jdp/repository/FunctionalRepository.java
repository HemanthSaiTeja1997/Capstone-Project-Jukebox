package com.niit.jdp.repository;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface FunctionalRepository {
     void toDisplaySelectedSongFromPlaylist(Connection connection, String playlistsName) throws SQLException;
}
