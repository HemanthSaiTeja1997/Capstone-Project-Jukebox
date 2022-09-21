/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

import java.util.ArrayList;
import java.util.List;

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
}
