/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayList {
    private int playListId;
    private String playListName;
    private List<Song> song;

    public PlayList() {
        song = new ArrayList<Song>();
    }

    public PlayList(int playListId, String playListName, List<Song> song) {
        this.playListId = playListId;
        this.playListName = playListName;
        this.song = song;
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

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return playListId == playList.playListId && Objects.equals(playListName, playList.playListName) && Objects.equals(song, playList.song);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playListId, playListName, song);
    }
}
