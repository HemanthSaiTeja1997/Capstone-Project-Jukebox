/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.service;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class MusicPlayerService {
    public void play(String songPath) {
        // 2. a file object that contains our song
        File songFile = new File(songPath);
        // 3. an object of the AudioInputStream class
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);
        } catch (UnsupportedAudioFileException | IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
