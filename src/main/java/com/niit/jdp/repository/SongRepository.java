/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SongRepository implements Repository<Song> {
    MusicPlayerService music = new MusicPlayerService();
    @Override
    public boolean addSongDetails(Connection connection, Song song) throws SQLException {
        // 1. write the query for inserting a new Song object into the `song` table
        String insertQuery = "INSERT INTO `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `duration`," + " `url`) VALUES (?,?,?,?,?,?,?);";
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
    public void songs(Connection connection) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in).useDelimiter("[,\\s+]");
        SongRepository songRepository = new SongRepository();
        PlayListRepository playListRepository = new PlayListRepository();
        DatabaseService databaseService = new DatabaseService();
        int choice = -1;
        do {
            System.out.println("Welcome to the Jukebox System");
            System.out.println("============================================");
            System.out.println("1. To Display All the Songs from Song Menu and Play Any Song ");
            System.out.println("8. To Display All the Songs from  playlist ");
            System.out.println("2. Select any song that you want from songs or playlist:");
            System.out.println("2. Add a new songList to the database");
            System.out.println("3. Search By Artist Name");
            System.out.println("4. Search By Genre");
            System.out.println("5. Search By Album");
            System.out.println("5. Search By SongId");
            System.out.println("6. Select the songId to add into playlist from above song list");
            System.out.println("7. Exit");
            System.out.println("============================================");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            try {
                databaseService.connect();
                switch (choice) {
                    case 1:
                        System.out.println("DISPLAY SONGS FROM MENU : ");
                        songRepository.getAllSongs(connection).forEach(System.out::println);
                        System.out.println("Choose a songId that you wise to listen ");
                        int songIdFormSongMenu = scanner.nextInt();
                        String urlOfSongIdFromMenu = songRepository.getURL(connection, songIdFormSongMenu);
                        music.play(urlOfSongIdFromMenu);
                        break;
                    case 8:
                        System.out.println("To Display All songs from playlist");
                        playListRepository.displayAllPlaylist(connection).forEach(System.out::println);
                        System.out.println("Enter the playlist Name to display playlist : ");
                        String name8 = scanner.next();
                        playListRepository.toDisplaySelectedSongFromPlaylist(connection, name8);
                        System.out.println("Choose a songId that you wish to listen : ");
                        int songIDThatYouWishToPlay = scanner.nextInt();
                        String urlForPlayingSelectedSong = playListRepository.getURL(connection, songIDThatYouWishToPlay);
                        music.play(urlForPlayingSelectedSong);
                        break;
                    case 6:
                        System.out.println("Please Enter playlist Name :");
                        String playlistName = scanner.next();
                        System.out.println("Please Enter song id with spaces");
                        String input = scanner.next();
                        String[] numbers = input.split(" ");
                        for (String songID : numbers) {
                            Song song3 = songRepository.getById(connection, Integer.parseInt(songID));
                            boolean result = false;
                            result = playListRepository.addSongDetails(connection, playlistName, song3);
                            if (result) {
                                System.out.println("Song added to playlist ");
                            } else {
                                System.out.println("Song not added to playlist");
                            }
                        }
                        System.out.println("DISPLAY PLAYLIST");
                        playListRepository.displayAllPlaylist(connection).forEach(System.out::println);
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
                    case 7:
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

    public String getURL(Connection connection, int songId) throws SQLException {
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
        String uRL = "";
        while (resultSet.next()) {
            // 6. fetch the values of the current row from the result set
            uRL = resultSet.getString("url");
            // 7. create a song object using the values fetched from the result set
        }
        System.out.println(uRL);
        return uRL;
    }

    public Song getById(Connection connection, int id) throws SQLException {
        // 1. write the query for selecting a song object from the `song` table
        String searchQuery = "SELECT*From `jukebox`.`song` where (`song_Id`=?);";
        Song song = new Song();
        // 2. create a statement object
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            // 3. set the values of the query parameters
            preparedStatement.setInt(1, id);
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
                song = new Song(songId, songName, album, artistName, gener, duration, uRL);
                // System.out.println(song.getUrl());
            }
            //  System.out.println(song);
            return song;
        }
    }

}


