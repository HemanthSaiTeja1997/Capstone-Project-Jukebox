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
    private int songId;
    private String playlistUrl;

    public PlayList() {
    }

    public PlayList(int playListId, String playListName, int songId, String playlistUrl) {
        this.playListId = playListId;
        this.playListName = playListName;
        this.songId = songId;
        this.playlistUrl = playlistUrl;
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

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getPlaylistUrl() {
        return playlistUrl;
    }

    public void setPlaylistUrl(String playlistUrl) {
        this.playlistUrl = playlistUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return playListId == playList.playListId && songId == playList.songId && Objects.equals(playListName, playList.playListName) && Objects.equals(playlistUrl, playList.playlistUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playListId, playListName, songId, playlistUrl);
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "playListId=" + playListId +
                ", playListName='" + playListName + '\'' +
                ", songId=" + songId +
                ", playlistUrl='" + playlistUrl + '\'' +
                '}';
    }
}
