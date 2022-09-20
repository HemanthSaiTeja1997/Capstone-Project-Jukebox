/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayerService {
    public void play(String songPath) {
        // 2. a file object that contains our song
        File songFile = new File(songPath);
        try {
            // 3. an object of the AudioInputStream class
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);
            // 4. get a clip object from the AudioSystem
            Clip clip = AudioSystem.getClip();
            // 5. use the clip object to open the audio input stream
            clip.open(audioInputStream);
            // 6. set a loop for the sound file
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
