package com.niit.jdp.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.AudioInputStream;

class MusicPlayerServiceTest {
    MusicPlayerService musicPlayerService;
    AudioInputStream audioInputStream;
    String music = "src/main/resources/songs/01-Shippuuden.wav";

    @BeforeEach
    void setUp() {
        musicPlayerService = new MusicPlayerService();
        audioInputStream = new AudioInputStream();

    }

    @AfterEach
    void tearDown() {
        musicPlayerService = null;
    }

    @Test
    void play() {
        musicPlayerService.play(music);
    }
}