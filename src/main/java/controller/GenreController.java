package controller;

import model.interfaces.Genre;
import service.DataHolder;

import java.sql.SQLException;
import java.util.List;

public class GenreController {

    private DataHolder dataHolder;

    public GenreController() {
        this.dataHolder = SharedController.getInstance().getDataHolder();
    }

    public void saveGenre(String name) throws SQLException {
        dataHolder.saveGenre(name);
    }

    public void saveGenre(Genre genre) throws SQLException {
        dataHolder.saveGenre(genre);
    }

    public List<Genre> getGenres() throws SQLException {
        return dataHolder.getGenres();
    }

    public void deleteGenre(String name) throws SQLException {
        dataHolder.removeGenre(name);
    }

    public void deleteGenre(Genre genre) throws SQLException {
        dataHolder.removeGenre(genre);
    }
}
