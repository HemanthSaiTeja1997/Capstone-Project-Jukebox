/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

import java.util.Objects;

public class Song {
    private int songId;
    private String name;
    private String album;
    private String artist;
    private String genre;
    private String duration;
    private String url;

    public Song() {
    }

    public Song(int songId, String name, String album, String artist, String genre, String duration, String url) {
        this.songId = songId;
        this.name = name;
        this.album = album;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
        this.url = url;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return songId == song.songId && Objects.equals(name, song.name) && Objects.equals(album, song.album) && Objects.equals(artist, song.artist) && Objects.equals(genre, song.genre) && Objects.equals(duration, song.duration) && Objects.equals(url, song.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, name, album, artist, genre, duration, url);
    }

    @Override
    public String toString() {
        return String.format("%-20s %-25s %-20s %-20s %-20s %-20s", songId, name, album, artist, genre, duration);

    }
}
