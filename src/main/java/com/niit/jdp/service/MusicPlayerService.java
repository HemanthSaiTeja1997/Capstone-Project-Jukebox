/*
 *Author Name :P.Hemanth Sai Teja
 *Date:20-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MusicPlayerService {
    Scanner scanner = new Scanner(System.in);

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
            // 7. start the sound file
            clip.start();
            System.out.println("YOU ARE NOW LISTENING TO YOUR SELECTED SONG");

            // 8. pause the current thread for the time the song is being played
//            long songDurationInMilliseconds = clip.getMicrosecondLength() / 100000L;
//            Thread.sleep(songDurationInMilliseconds);
            System.out.println("\u001B[31mPress any integer to stop the song\u001B[0m");
            int stop = scanner.nextInt();
            clip.stop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            System.err.println(exception.getMessage());
            exception.printStackTrace();
//        } catch (InterruptedException exception) {
//            System.err.println("song thread was interrupted");
//        }
            scanner.close();
        }
    }
}
