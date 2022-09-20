/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

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
}
