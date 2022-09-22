/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp;

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlayListRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class JukeboxImplementation {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        DatabaseService databaseService = new DatabaseService();
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        SongRepository songRepository = new SongRepository();
        PlayListRepository playListRepository = new PlayListRepository();
        MusicPlayerService musicPlayerService = new MusicPlayerService();
//        System.out.println("select song id from song list to play song:");
//        int songid = scanner.nextInt();
//        String url = songRepository.getURL(connection, songid);
//        musicPlayerService.play(


//        //songRepository.getById(connection,1);
//
////        System.out.println("Enter any song number from 1 to 14 :");
//////        int j = scanner.nextInt();
////        System.out.println("Enter number");
////        int Id = scanner.nextInt();
////        songRepository.getURL(connection, Id);
        songRepository.songs(connection);
        List<Song> allSongs = songRepository.getAllSongs(connection);
//PlayList play = new PlayList(1,"hemanth",allSongs);
//playListRepository.addSongDetails(connection,play);
//        // songRepository.searchByArtistAndSortByName(connection, "Yasuharu Takanashi").forEach(System.out::println);
//        // songRepository.searchByGenreAndSortByName(connection, "Industrial Metal").forEach(System.out::println);

    }
}
