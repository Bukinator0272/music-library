package controller;

import model.interfaces.Genre;
import service.DataHolder;

import java.sql.SQLException;
import java.util.List;

public class GenreController {

    private DataHolder dataHolder;

    public void addGenre(String name) throws SQLException {
        dataHolder.addGenre(name);
    }

    public int getGenresCount() {
        return dataHolder.getGenresCount();
    }

    public List<Genre> getGenres() throws SQLException {
        return dataHolder.getGenres();
    }

    public void deleteGenre(String name) throws SQLException {
        dataHolder.removeGenre(name);
    }

    public void updateGenre(String name, String newName) throws SQLException {
        dataHolder.updateGenre(name, newName);
    }
}
