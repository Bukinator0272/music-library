package service;

import model.interfaces.Genre;
import model.interfaces.Track;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {

    private List<Track> tracks;
    private List<Genre> genres;

    public DataHolder() {
        tracks = new ArrayList<>();
        genres = new ArrayList<>();
    }

    void addTrack(Track track) {
        tracks.add(track);
//        GenreDAO genreDAO = new GenreDAO();
//        genreDAO.add(track);
    }

    void addGenre(Genre genre) {
        genres.add(genre);
//        GenreDAO genreDAO = new GenreDAO();
//        genreDAO.add(genre);
    }

    public List<Track> getAlbums() {
        return tracks;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public int getTraksCount() {
        return tracks.size();
    }

    public int getGenresCount() {
        return genres.size();
    }

    //wrong argument
    public Track getTrack(Track track) {
        tracks.add(track);
//        GenreDAO genreDAO = new GenreDAO();
//        genreDAO.add(track);
        return track;
    }

    //wrong argument
    public Genre getGenre(Genre genre) {
        genres.add(genre);
//        GenreDAO genreDAO = new GenreDAO();
//        genreDAO.add(genre);
        return genre;
    }

    //wrong argument
    //wrong statement
    void updateTrack(Track track) {
        tracks.add(track);
//        GenreDAO genreDAO = new GenreDAO();
//        genreDAO.add(track);
    }

    //wrong argument
    //wrong statement
    void updateGenre(Genre genre) {
        genres.add(genre);
//        GenreDAO genreDAO = new GenreDAO();
//        genreDAO.add(genre);
    }

    //wrong argument
    void deleteTrack(Track track) {
        tracks.remove(track);
//        GenreDAO genreDAO = new GenreDAO();
//        genreDAO.add(track);
    }

    //wrong argument
    void deleteGenre(Genre genre) {
        genres.remove(genre);
//        GenreDAO genreDAO = new GenreDAO();
//        genreDAO.add(genre);
    }

}
