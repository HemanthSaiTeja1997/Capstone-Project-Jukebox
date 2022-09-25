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
    private String songNameOfPlaylist;

    public PlayList(int playListId, String playListName, int songId, String playlistUrl, String songNameOfPlaylist) {
        this.playListId = playListId;
        this.playListName = playListName;
        this.songId = songId;
        this.playlistUrl = playlistUrl;
        this.songNameOfPlaylist = songNameOfPlaylist;
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

    public String getSongNameOfPlaylist() {
        return songNameOfPlaylist;
    }

    public void setSongNameOfPlaylist(String songNameOfPlaylist) {
        this.songNameOfPlaylist = songNameOfPlaylist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return playListId == playList.playListId && songId == playList.songId && Objects.equals(playListName, playList.playListName) && Objects.equals(playlistUrl, playList.playlistUrl) && Objects.equals(songNameOfPlaylist, playList.songNameOfPlaylist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playListId, playListName, songId, playlistUrl, songNameOfPlaylist);
    }

    @Override
    public String toString() {
        return String.format("\u001B[35m%-20s %-25s %-20s \u001B[0m", playListName, songId, songNameOfPlaylist);

    }
}
