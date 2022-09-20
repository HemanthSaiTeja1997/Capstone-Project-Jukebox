/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

import java.util.Objects;

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

    public int getPlayListId() {
        return playListId;
    }

    public void setPlayListId(int playListId) {
        this.playListId = playListId;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public String getPlayListArtist() {
        return playListArtist;
    }

    public void setPlayListArtist(String playListArtist) {
        this.playListArtist = playListArtist;
    }

    public String getPlayListGenres() {
        return playListGenres;
    }

    public void setPlayListGenres(String playListGenres) {
        this.playListGenres = playListGenres;
    }

    public String getPlayListDuration() {
        return playListDuration;
    }

    public void setPlayListDuration(String playListDuration) {
        this.playListDuration = playListDuration;
    }

    public String getPlayListURL() {
        return playListURL;
    }

    public void setPlayListURL(String playListURL) {
        this.playListURL = playListURL;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return playListId == playList.playListId && songId == playList.songId && Objects.equals(playListName,
                playList.playListName) && Objects.equals(playListArtist, playList.playListArtist) &&
                Objects.equals(playListGenres, playList.playListGenres) && Objects.equals(playListDuration,
                playList.playListDuration) && Objects.equals(playListURL, playList.playListURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playListId, playListName, playListArtist, playListGenres, playListDuration, playListURL,
                songId);
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "playListId=" + playListId +
                ", playListName='" + playListName + '\'' +
                ", playListArtist='" + playListArtist + '\'' +
                ", playListGenres='" + playListGenres + '\'' +
                ", playListDuration='" + playListDuration + '\'' +
                ", playListURL='" + playListURL + '\'' +
                ", songId=" + songId +
                '}';
    }
}
