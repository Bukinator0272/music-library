package controller;

import service.DataHolder;

public class TrackController {

    private DataHolder dataHolder;

    public void addTrack(String name, String author, String album, String genre, int duration) {
        dataHolder.addTrack(name, author, album, genre, duration);
    }
}
