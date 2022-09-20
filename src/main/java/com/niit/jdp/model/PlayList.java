/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

public class PlayList {
    private int playListId;
    private String playListName;
    private String playListArtist;
    private String playListGenres;
    private String playListDuration;
    private String playListURL;
    private int songId;

    public PlayList() {
    }

    public PlayList(int playListId, String playListName, String playListArtist, String playListGenres, String playListDuration, String playListURL, int songId) {
        this.playListId = playListId;
        this.playListName = playListName;
        this.playListArtist = playListArtist;
        this.playListGenres = playListGenres;
        this.playListDuration = playListDuration;
        this.playListURL = playListURL;
        this.songId = songId;
    }
}
