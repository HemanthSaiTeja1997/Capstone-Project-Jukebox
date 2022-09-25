/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp;

import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;

import java.sql.Connection;
import java.sql.SQLException;

public class JukeboxImplementation {
    /**
     * It connects to the database and prints out the songs in the database.
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseService databaseService = new DatabaseService();
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        SongRepository songRepository = new SongRepository();
        songRepository.songs(connection);
    }
}
