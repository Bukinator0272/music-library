package service;

import model.interfaces.Genre;
import model.interfaces.Track;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {

    private List<Track> traks;
    private List<Genre> genres;

    public DataHolder() {
        traks = new ArrayList<>();
        genres = new ArrayList<>();
    }

    public List<Track> getAlbums() {
        return traks;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    void addTrack(Track track) {
        traks.add(track);
//        GenreDAO genreDAO = new GenreDAO();
//        genreDAO.add(track);
    }

    void addGenre(Genre genre) {
        genres.add(genre);
//        GenreDAO genreDAO = new GenreDAO();
//        genreDAO.add(genre);
    }

}
