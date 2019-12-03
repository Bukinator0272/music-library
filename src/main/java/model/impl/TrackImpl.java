package model.impl;

import model.interfaces.Track;

import java.util.UUID;

public class TrackImpl implements Track {

    private UUID id;
    private String name;
    private String author;
    private String album;
    private String genre;
    private long duration;

    public TrackImpl() {
    }

    public TrackImpl(UUID id, String name, String author, String album, String genre, long duration) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.album = album;
        this.genre = genre;
        this.duration = duration;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getAlbum() {
        return album;
    }

    @Override
    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public long getDuration() {
        return duration;
    }

    @Override
    public void setDuration(long duration) {
        this.duration = duration;
    }
}
