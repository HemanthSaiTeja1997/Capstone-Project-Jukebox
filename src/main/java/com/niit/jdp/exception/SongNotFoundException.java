/*
 *Author Name :P.Hemanth Sai Teja
 *Date:25-09-2022
 *Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.exception;

public class SongNotFoundException extends Exception {
    final String message;

    public SongNotFoundException(String output) {
        message = output;
    }

    @Override
    public String toString() {
        return ("Custom Exception : " + message);
    }
}
