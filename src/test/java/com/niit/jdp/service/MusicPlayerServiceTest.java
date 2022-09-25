package com.niit.jdp.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

class MusicPlayerServiceTest {
    MusicPlayerService musicPlayerService;
    AudioInputStream audioInputStream;
    String music = "src/main/resources/songs/01-Shippuuden.wav";

    @BeforeEach
    void setUp() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        musicPlayerService = new MusicPlayerService();
        audioInputStream = AudioSystem.getAudioInputStream(new File(music));
    }

    @AfterEach
    void tearDown() {
        musicPlayerService = null;
    }

    @Test
    void play() throws LineUnavailableException, IOException {
        Clip clip = AudioSystem.getClip();

        musicPlayerService.play(music);

    }
}