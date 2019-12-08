package service;

import model.dbservice.connection.DataBaseService;
import model.dbservice.dao.GenreDAO;
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

    public void addGenre(String name) throws SQLException {
        Genre genre = new GenreImpl(name);
        genres.add(genre);
        GenreDAO genreDAO = new GenreDAO(db.getConnection());
        genreDAO.insert(genre);
    }

    public void removeGenre(String name) throws SQLException {
        Genre genre = getGenreByName(name);
        if (genre!=null){
            genres.remove(genre);
            GenreDAO genreDAO = new GenreDAO(db.getConnection());
            genreDAO.delete(genre.getId());
        }
    }

    public void updateGenre(String name, String newName) throws SQLException {
        if (name != null && newName!=null){
            Genre genre = getGenreByName(name);
            if (genre!=null){
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

    public int getTracksCount() {
        return tracks.size();
    }

    public int getGenresCount() {
        return genres.size();
    }
}
