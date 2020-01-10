package model.impl;

import model.interfaces.Genre;
import model.interfaces.Track;

public class TrackImpl implements Track {

    private Long id;
    private String name;
    private String author;
    private String album;
    private Genre genre;
    private Integer duration;

    public TrackImpl(Long id, String name, String author, String album, Genre genre, int duration) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.album = album;
        this.genre = genre;
        this.duration = duration;
    }

    public TrackImpl(String name, String author, String album, Genre genre, int duration) {
        this.name = name;
        this.author = author;
        this.album = album;
        this.genre = genre;
        this.duration = duration;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public Genre getGenre() {
        return genre;
    }

    @Override
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public Integer getDuration() {
        return duration;
    }

    @Override
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
