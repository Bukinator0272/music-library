package service;

import model.dbservice.connection.DataBaseService;
import model.dbservice.dao.GenreDAO;
import model.dbservice.dao.TrackDAO;
import model.impl.GenreImpl;
import model.impl.TrackImpl;
import model.interfaces.Genre;
import model.interfaces.Track;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    private DataBaseService db = DataBaseService.getInstance();
    private List<Track> tracks;
    private List<Genre> genres;

    public DataHolder() {
        tracks = new ArrayList<>();
        genres = new ArrayList<>();
    }

    private Genre getGenreByName(String name) {
        for (Genre genre : genres) {
            if (genre.getName().equals(name)) return genre;
        }
        return null;
    }

    public List<Genre> getGenres() throws SQLException {
        GenreDAO genreDAO = new GenreDAO(db.getConnection());
        return genreDAO.getAll();
    }

    public void saveGenre(String name) throws SQLException {
        Genre genre = new GenreImpl(name);
        genres.add(genre);
        GenreDAO genreDAO = new GenreDAO(db.getConnection());
        genreDAO.save(genre);
    }

    public void saveGenre(Genre genre) throws SQLException {
        GenreDAO genreDAO = new GenreDAO(db.getConnection());
        genreDAO.save(genre);
    }

    public void saveTrack(Track track) throws SQLException {
        TrackDAO trackDAO = new TrackDAO(db.getConnection());
        trackDAO.save(track);
    }

    public void removeGenre(String name) throws SQLException {
        Genre genre = getGenreByName(name);
        if (genre != null) {
            genres.remove(genre);
            GenreDAO genreDAO = new GenreDAO(db.getConnection());
            genreDAO.delete(genre.getId());
        }
    }


    public void removeGenre(Genre genre) throws SQLException {
        if (genre != null) {
            //genres.remove(genre);
            GenreDAO genreDAO = new GenreDAO(db.getConnection());
            genreDAO.delete(genre);
        }
    }


    public void removeTrack(Track track) throws SQLException {
        if (track != null) {
            //genres.remove(genre);
            TrackDAO trackDAO = new TrackDAO(db.getConnection());
            trackDAO.delete(track);
        }
    }

    public void updateGenre(String name, String newName) throws SQLException {
        if (name != null && newName != null) {
            Genre genre = getGenreByName(name);
            if (genre != null) {
                genre.setName(newName);
                GenreDAO genreDAO = new GenreDAO(db.getConnection());
                genreDAO.update(genre);
            }
        }
    }

    public void addTrack(String name, String author, String album, String genre, int duration) {
        Track track = new TrackImpl(name, author, album, getGenreByName(genre), duration);
        tracks.add(track);
//        GenreDAO genreDAO = new GenreDAO();
//        genreDAO.add(track);
    }

    public List<Track> getTracks() throws SQLException {
        TrackDAO trackDAO = new TrackDAO(db.getConnection());
        return trackDAO.getAll();
    }


}
