/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SongRepository implements Repository<Song> {
    @Override
    public boolean addSongDetails(Connection connection, Song song) throws SQLException {
        // 1. write the query for inserting a new Song object into the `song` table
        String insertQuery = "INSERT INTO `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `duration`,"
                + " `url`) VALUES (?,?,?,?,?,?,?);";
        // 2. create a statement object
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // 3. set the values of the query parameters
            preparedStatement.setInt(1, song.getSongId());
            preparedStatement.setString(2, song.getName());
            preparedStatement.setString(3, song.getAlbum());
            preparedStatement.setString(4, song.getArtist());
            preparedStatement.setString(5, song.getGenre());
            preparedStatement.setString(6, song.getDuration());
            preparedStatement.setString(7, song.getUrl());
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    @Override
    public List<Song> getAllSongs(Connection connection) throws SQLException {
        List<Song> songList = new ArrayList<>();
        //create SQL query to retrieve all the rows from the Song table
        String selectAllSongs = "SELECT * FROM `jukebox`.`song`;";
        //use the connection object to execute the query for selecting all songs
        ResultSet resultSet = connection.createStatement().executeQuery(selectAllSongs);
        //iterate over the result set and create a Song object for each row
        while (resultSet.next()) {
            int songId = resultSet.getInt("song_Id");
            String songName = resultSet.getString("name");
            String album = resultSet.getString("album");
            String artistName = resultSet.getString("artist");
            String gener = resultSet.getString("genre");
            String duration = resultSet.getString("duration");
            String uRL = resultSet.getString("url");
            //create a Song object using the values fetched from the result set
            Song newSong = new Song(songId, songName, album, artistName, gener, duration, uRL);
            songList.add(newSong);
        }
        return songList;
    }

    @Override
    public List<Song> searchByArtistAndSortByName(Connection connection, String artist) throws SQLException {
        // 1. write the query for selecting a song object from the `song` table
        String searchQuery = "SELECT*From `jukebox`.`song` where (`artist`=?);";
        List<Song> songList = new ArrayList<>();
        // 2. create a statement object
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            // 3. set the values of the query parameters
            preparedStatement.setString(1, artist);
            //4. execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            // 5. check if the result set is empty
            while (resultSet.next()) {
                // 6. fetch the values of the current row from the result set
                int songId = resultSet.getInt("song_Id");
                String songName = resultSet.getString("name");
                String album = resultSet.getString("album");
                String artistName = resultSet.getString("artist");
                String gener = resultSet.getString("genre");
                String duration = resultSet.getString("duration");
                String uRL = resultSet.getString("url");
                // 7. create a song object using the values fetched from the result set
                Song song = new Song(songId, songName, album, artistName, gener, duration, uRL);
                songList.add(song);
                songList.sort(Comparator.comparing(Song::getName));
            }

            return songList;
        }
    }

    @Override
    public List<Song> searchByGenreAndSortByName(Connection connection, String genre) throws SQLException {
        // 1. write the query for selecting a song object from the `song` table
        String searchQuery = "SELECT*From `jukebox`.`song` where (`genre`=?);";
        List<Song> songList = new ArrayList<>();
        // 2. create a statement object
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            // 3. set the values of the query parameters
            preparedStatement.setString(1, genre);
            //4. execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            // 5. check if the result set is empty
            while (resultSet.next()) {
                // 6. fetch the values of the current row from the result set
                int songId = resultSet.getInt("song_Id");
                String songName = resultSet.getString("name");
                String album = resultSet.getString("album");
                String artistName = resultSet.getString("artist");
                String gener = resultSet.getString("genre");
                String duration = resultSet.getString("duration");
                String uRL = resultSet.getString("url");
                // 7. create a song object using the values fetched from the result set
                Song song = new Song(songId, songName, album, artistName, gener, duration, uRL);
                songList.add(song);
                songList.sort(Comparator.comparing(Song::getName));
            }
            return songList;
        }
    }

    @Override
    public List<Song> searchByAlbumAndSortByName(Connection connection, String album) throws SQLException {
        // 1. write the query for selecting a song object from the `song` table
        String searchQuery = "SELECT*From `jukebox`.`song` where (`album`=?);";
        List<Song> songList = new ArrayList<>();
        // 2. create a statement object
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            // 3. set the values of the query parameters
            preparedStatement.setString(1, album);
            //4. execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            // 5. check if the result set is empty
            while (resultSet.next()) {
                // 6. fetch the values of the current row from the result set
                int songId = resultSet.getInt("song_Id");
                String songName = resultSet.getString("name");
                String albums = resultSet.getString("album");
                String artistName = resultSet.getString("artist");
                String gener = resultSet.getString("genre");
                String duration = resultSet.getString("duration");
                String uRL = resultSet.getString("url");
                // 7. create a song object using the values fetched from the result set
                Song song = new Song(songId, songName, albums, artistName, gener, duration, uRL);
                songList.add(song);
                songList.sort(Comparator.comparing(Song::getName));
            }
            return songList;
        }
    }

    @Override
    public void songs(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        SongRepository songRepository = new SongRepository();
        DatabaseService databaseService = new DatabaseService();
        int choice = -1;
        do {
            System.out.println("Welcome to the Jukebox System");
            System.out.println("============================================");
            System.out.println("1. To Display All the Songs");
            System.out.println("2. Search By Artist Name");
            System.out.println("3. Search By Genre");
            System.out.println("4. Search By Album");
            System.out.println("5. Exit");
            System.out.println("============================================");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            try {
                databaseService.connect();
                switch (choice) {
                    case 1:
                        System.out.println("To Display All the Songs");
                        songRepository.getAllSongs(connection).forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("Add a new songList to the database");
                        System.out.println("Enter the songId: ");
                        int songId = scanner.nextInt();
                        System.out.println("Enter the song name: ");
                        String songName = scanner.next();
                        System.out.println("Enter the albumName: ");
                        String album = scanner.next();
                        System.out.println("Enter the artistName: ");
                        String artistName1 = scanner.next();
                        System.out.println("Enter the song Genre: ");
                        String genre = scanner.next();
                        System.out.println("Enter the song duration: ");
                        String duration = scanner.next();
                        System.out.println("Enter the song URL: ");
                        String uRL = scanner.next();
                        Song song = new Song(songId, songName, album, artistName1, genre, duration, uRL);
                        songRepository.addSongDetails(connection, song);
                        System.out.println("\u001B[32mA New Song List Entered successfully.\u001B[0m");
                        break;

                    case 3:
                        System.out.println("To Search By Artist Name");
                        String artistName = scanner.next();
                        songRepository.searchByArtistAndSortByName(connection, artistName).forEach(System.out::println);
                        break;
                    case 4:
                        System.out.println("To Search By Genre");
                        String genreName = scanner.next();
                        songRepository.searchByGenreAndSortByName(connection, genreName).forEach(System.out::println);
                        break;
                    case 5:
                        System.out.println("To Search By Album");
                        String albumName = scanner.next();
                        songRepository.searchByAlbumAndSortByName(connection, albumName).forEach(System.out::println);
                        break;
                    case 6:
                        System.out.println("Exit");
                        break;
                    default:
                        System.err.println("Invalid choice");
                }

            } catch (ClassNotFoundException exception) {
                exception.printStackTrace();
                System.out.println(exception);
            }
        } while (choice != 6);
    }

    public List<Song> getURL(Connection connection, int songId) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        List<Song> songList = new ArrayList<>();
        // 1. write the query for selecting a song object from the `song` table
        String getQuery = "SELECT`url`From `jukebox`.`song` where (`song_Id`=?);";
        // 2. create a statement object
        PreparedStatement preparedStatement = connection.prepareStatement(getQuery);
        // 3. set the values of the query parameters
        preparedStatement.setInt(1, songId);
        //4. execute the query
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            // 6. fetch the values of the current row from the result set
            int songId5 = resultSet.getInt("song_Id");
            String songName = resultSet.getString("name");
            String albums = resultSet.getString("album");
            String artistName = resultSet.getString("artist");
            String gener = resultSet.getString("genre");
            String duration = resultSet.getString("duration");
            String uRL = resultSet.getString("url");
            // 7. create a song object using the values fetched from the result set
            Song song = new Song(songId, songName, albums, artistName, gener, duration, uRL);
            songList.add(song);
        }
        return songList;
    }

}

