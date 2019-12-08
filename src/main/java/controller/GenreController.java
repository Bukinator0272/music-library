package controller;

import service.DataHolder;

import java.sql.SQLException;

public class GenreController {

    private DataHolder dataHolder;

    public int getGenresCount() {
        return dataHolder.getGenresCount();
    }

    void addGenre(String name) throws SQLException {
        dataHolder.addGenre(name);
    }
}
