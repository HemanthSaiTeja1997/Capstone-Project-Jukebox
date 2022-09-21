/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp;

import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.Connection;
import java.sql.SQLException;

public class JukeboxImplementation {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseService databaseService = new DatabaseService();
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        SongRepository songRepository = new SongRepository();
        MusicPlayerService musicPlayerService = new MusicPlayerService();
        // musicPlayerService.play("src/main/resources/songs/akatsuki-theme.wav");
        // songRepository.getAllSongs(connection).forEach(System.out::println);
        songRepository.searchAndSortByArtist(connection, "Yasuharu Takanashi").forEach(System.out::println);

    }
}
