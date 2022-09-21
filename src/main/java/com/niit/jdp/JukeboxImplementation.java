/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp;

import com.niit.jdp.service.MusicPlayerService;

public class JukeboxImplementation {
    public static void main(String[] args) {
        MusicPlayerService musicPlayerService = new MusicPlayerService();
        musicPlayerService.play("src/main/resources/songs/akatsuki-theme.wav");
    }
}
