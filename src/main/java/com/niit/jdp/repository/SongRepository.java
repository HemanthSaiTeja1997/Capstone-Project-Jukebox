/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.exception.SongNotFoundException;
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

    /**
     * It takes a `Connection` object and a `Song` object as parameters and returns a boolean value
     *
     * @param connection The connection object that is used to connect to the database.
     * @param song       The Song object that needs to be added to the database.
     * @return The number of rows affected by the query.
     */
    @Override
    public boolean addSongDetails(Connection connection, Song song) throws SQLException {
        // 1. write the query for inserting a new Song object into the `song` table
        String insertQuery = "INSERT INTO `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`," + " `genre`, `duration`,`url`) VALUES (?,?,?,?,?,?,?);";
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

    /**
     * It creates a SQL query to select all the rows from the Song table, executes the query using the connection object,
     * iterates over the result set and creates a Song object for each row and returns the list of Song objects
     *
     * @param connection This is the connection object that we created in the main method.
     * @return A list of all the songs in the database.
     */
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

    /**
     * It takes a connection object and an artist name as input and returns a list of songs by that artist sorted by name
     *
     * @param connection The connection object that is used to connect to the database.
     * @param artist     The artist name to search for.
     * @return A list of songs that are sorted by name.
     */
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

    /**
     * It takes a connection object and a genre as input and returns a list of songs that belong to the given genre
     *
     * @param connection The connection object that is used to connect to the database.
     * @param genre      The genre of the song.
     * @return A list of songs that are sorted by name.
     */
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

    /**
     * It takes a connection object and a string as input and returns a list of song objects
     *
     * @param connection The connection object that is used to connect to the database.
     * @param album      The album name to search for.
     * @return A list of songs that match the album name and are sorted by name.
     */
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

    /**
     * This function is used to display all the songs from the song menu and play any song, display all the songs from the
     * playlist menu and play any song, add a new song list to the database by the owner of the jukebox, search by artist
     * name, search by genre, search by album, select the song id to add into playlist from above song list and exit
     *
     * @param connection This is the connection object that is used to connect to the database.
     */
    @Override
    public void songs(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in).useDelimiter("[,\\s+]");
        SongRepository songRepository = new SongRepository();
        PlayListRepository playListRepository = new PlayListRepository();
        DatabaseService databaseService = new DatabaseService();
        int choice;
        do {
            System.out.println("\u001B[32m Welcome to the Jukebox System\u001B[0m");
            System.out.println("============================================");
            System.out.println("\u001B[36m1. To Display All the Songs from Song Menu and Play Any Song ");
            System.out.println("2. To Display All the Songs from  playlist Menu and Play Any Song ");
            System.out.println("3. Add a new songList to the database by the owner of jukebox ");
            System.out.println("4. Search By Artist Name");
            System.out.println("5. Search By Genre");
            System.out.println("6. Search By Album");
            System.out.println("7. Select the songId to add into playlist from above song list\u001B[0m");
            System.out.println("\u001B[31m8. Exit\u001B[0m");
            System.out.println("============================================");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            try {
                databaseService.connect();
                switch (choice) {
                    case 1:
                        System.out.println("\u001B[32m********************************************* SONG MENU  **************************************************************** \u001B[0m");
                        System.out.println("\u001B[33m+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\u001B[0m");
                        System.out.println("\u001B[34m SONG_ID             SONG_NAME                  ALBUM                    ARTIST              GENRE         DURATION   \u001B[0m");
                        System.out.println("\u001B[33m+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\u001B[0m");
                        songRepository.getAllSongs(connection).forEach(System.out::println);
                        System.out.println("Choose a songId that you wise to listen ");
                        int songIdFormSongMenu = scanner.nextInt();
                        String urlOfSongIdFromMenu = songRepository.getURL(connection, songIdFormSongMenu);
                        System.out.println(" Enter 1 to play : Enter 0 to Exit");
                        int option = scanner.nextInt();
                        if (option == 1) {
                            System.out.println("* \u001B[32m SONG PLAYING \u001B[0m *");
                            music.play(urlOfSongIdFromMenu);
                        } else {
                            System.out.println("*********************\u001B[31mExited from MusicPlayer\u001B[0m *********************");
                        }
                        break;
                    case 2:
                        System.out.println("*************\u001B[32mDisplaying All Songs From Playlist\u001B[0m *************");
                        System.out.println("\u001B[33m++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\u001B[0m");
                        System.out.println("\u001B[34mPLAYLIST_NAME      SONG_ID                        SONG_NAME\u001B[0m");
                        System.out.println("\u001B[33m++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\u001B[0m");
                        playListRepository.displayAllPlaylist(connection).forEach(System.out::println);
                        System.out.println("Enter the playlist Name to display playlist : ");
                        String name8 = scanner.next();
                        System.out.println("\u001B[33m++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\u001B[0m");
                        System.out.println("\u001B[34mSONG_ID           SONG_NAME  \u001B[0m");
                        System.out.println("\u001B[33m++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\u001B[0m");
                        playListRepository.toDisplaySelectedSongFromPlaylist(connection, name8);
                        System.out.println("Choose a songId that you wish to listen : ");
                        int songIDThatYouWishToPlay = scanner.nextInt();
                        String urlForPlayingSelectedSong = playListRepository.getURL(connection, songIDThatYouWishToPlay);
                        System.out.println("\u001B[32m Enter 1 to play : Enter 0 to Exit\u001B[0m");
                        int option9 = scanner.nextInt();
                        if (option9 == 1) {
                            System.out.println("* \u001B[32m SONG PLAYING \u001B[0m *");
                            music.play(urlForPlayingSelectedSong);
                        } else {
                            System.err.println("Exited from MusicPlayer");
                        }
                        break;
                    case 3:
                        System.out.println("you can add song to song list only if you are owner of this jukebox");
                        System.out.println("Enter the USER PASSWORD");
                        int password = scanner.nextInt();
                        if (password == 123456789) {
                            System.out.println("PASSWORD MATCHED");
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
                        } else {
                            System.err.println("ENTERED WRONG PASSWORD");
                        }
                        break;
                    case 4:
                        System.out.println("\u001B[32m********************************************* SONG MENU  **************************************************************** \u001B[0m");
                        System.out.println("\u001B[33m+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\u001B[0m");
                        System.out.println("\u001B[34m SONG_ID             SONG_NAME                  ALBUM                    ARTIST              GENRE         DURATION   \u001B[0m");
                        System.out.println("\u001B[33m+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\u001B[0m");
                        songRepository.getAllSongs(connection).forEach(System.out::println);
                        System.out.println("To Search songs By Artist Name and Play Song");
                        String artistName = scanner.next();
                        System.out.println("SONG_ID             SONG_NAME                  ALBUM                    ARTIST              GENRE         DURATION   ");
                        songRepository.searchByArtistAndSortByName(connection, artistName).forEach(System.out::println);
                        System.out.println("Choose a songId form Artist you wish to listen");
                        int songIdThatYouWantToChooseFromArtistList = scanner.nextInt();
                        songRepository.getSongById(connection, songIdThatYouWantToChooseFromArtistList);
                        String urlOfSongIdFromArtistThatToPlay = songRepository.getURL(connection, songIdThatYouWantToChooseFromArtistList);
                        System.out.println("\u001B[32m Enter 1 to play : Enter 0 to Exit\u001B[0m");
                        int option2 = scanner.nextInt();
                        if (option2 == 1) {
                            System.out.println("* \u001B[32m SONG PLAYING \u001B[0m *");
                            music.play(urlOfSongIdFromArtistThatToPlay);
                        } else {
                            System.err.println("Exited from MusicPlayer");
                        }
                        break;
                    case 5:
                        System.out.println("\u001B[32m********************************************* SONG MENU  **************************************************************** \u001B[0m");
                        System.out.println("\u001B[33m+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\u001B[0m");
                        System.out.println("\u001B[34m SONG_ID             SONG_NAME                  ALBUM                    ARTIST              GENRE         DURATION   \u001B[0m");
                        System.out.println("\u001B[33m+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\u001B[0m");
                        songRepository.getAllSongs(connection).forEach(System.out::println);
                        System.out.println("To Search By Genre");
                        String genreName = scanner.next();
                        System.out.println("SONG_ID             SONG_NAME                  ALBUM                    ARTIST              GENRE         DURATION   ");
                        songRepository.searchByGenreAndSortByName(connection, genreName).forEach(System.out::println);
                        System.out.println("Choose a songId form Genre you wish to listen");
                        int songIdThatYouWantToChooseFromGenre = scanner.nextInt();
                        songRepository.getSongById(connection, songIdThatYouWantToChooseFromGenre);
                        String urlOfSongIdFromGenreThatToPlay = songRepository.getURL(connection, songIdThatYouWantToChooseFromGenre);
                        System.out.println("\u001B[32m Enter 1 to play : Enter 0 to Exit\u001B[0m");
                        int option3 = scanner.nextInt();
                        if (option3 == 1) {
                            System.out.println("* \u001B[32m SONG PLAYING \u001B[0m *");
                            music.play(urlOfSongIdFromGenreThatToPlay);
                        } else {
                            System.err.println("Exited from MusicPlayer");
                        }
                        break;
                    case 6:
                        System.out.println("\u001B[32m********************************************* SONG MENU  **************************************************************** \u001B[0m");
                        System.out.println("\u001B[33m+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\u001B[0m");
                        System.out.println("\u001B[34m SONG_ID             SONG_NAME                  ALBUM                    ARTIST              GENRE         DURATION   \u001B[0m");
                        System.out.println("\u001B[33m+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\u001B[0m");
                        songRepository.getAllSongs(connection).forEach(System.out::println);
                        System.out.println("To Search By Album");
                        String albumName = scanner.next();
                        System.out.println("SONG_ID             SONG_NAME                  ALBUM                    ARTIST              GENRE         DURATION   ");
                        songRepository.searchByAlbumAndSortByName(connection, albumName).forEach(System.out::println);
                        System.out.println("Choose a songId form Album you wish to listen");
                        int songIdThatYouWantToChooseFromAlbum = scanner.nextInt();
                        songRepository.getSongById(connection, songIdThatYouWantToChooseFromAlbum);
                        String urlOfSongIdFromAlbumThatToPlay = songRepository.getURL(connection, songIdThatYouWantToChooseFromAlbum);
                        System.out.println("\u001B[32m Enter 1 to play : Enter 0 to Exit\u001B[0m");
                        int option4 = scanner.nextInt();
                        if (option4 == 1) {
                            System.out.println("* \u001B[32m SONG PLAYING \u001B[0m *");
                            music.play(urlOfSongIdFromAlbumThatToPlay);
                        } else {
                            System.err.println("Exited from MusicPlayer");
                        }
                        break;
                    case 7:
                        System.out.println("\u001B[32m********************************************* SONG MENU  **************************************************************** \u001B[0m");
                        System.out.println("\u001B[33m+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\u001B[0m");
                        System.out.println("\u001B[34m SONG_ID             SONG_NAME                  ALBUM                    ARTIST              GENRE         DURATION   \u001B[0m");
                        System.out.println("\u001B[33m+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\u001B[0m");
                        songRepository.getAllSongs(connection).forEach(System.out::println);
                        System.out.println("Please Enter playlist Name :");
                        String playlistName = scanner.next();
                        System.out.println("Please Enter song Id");
                        String input = scanner.next();
                        String[] numbers = input.split(" ");
                        for (String songID : numbers) {
                            Song song3 = songRepository.getSongById(connection, Integer.parseInt(songID));
                            boolean result;
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
                    case 8:
                        System.out.println("Exit");
                        break;
                    default:
                        System.err.println("Invalid choice");
                }

            } catch (ClassNotFoundException exception) {
                exception.printStackTrace();
            }
        } while (choice != 8);
    }

    /**
     * > This function takes a connection object and a song id as input and returns the url of the song with the given id
     *
     * @param connection the connection object that is used to connect to the database
     * @param songId     the id of the song to be fetched
     * @return The URL of the song
     */
    public String getURL(Connection connection, int songId) throws SQLException {
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
        return uRL;
    }

    /**
     * It takes a connection object and an id as input and returns a song object
     *
     * @param connection The connection object that is used to connect to the database.
     * @param id         the id of the song to be fetched
     * @return The song object is being returned.
     */
    public Song getSongById(Connection connection, int id) throws SQLException {
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
                if (songId == 0) {
                    throw new SongNotFoundException("The song is not in the list!! Try using Valid choice.");

                }
            }
        } catch (SongNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        return song;
    }
}


