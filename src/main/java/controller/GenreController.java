package controller;

import model.impl.GenreImpl;
import model.interfaces.Genre;
import service.DataHolder;
import java.util.List;
import java.util.UUID;

public class GenreController {

    private DataHolder dataHolder;

    public int getGenresCount() {
        return dataHolder.getGenresCount();
    }

    void addGenre(String name) {
        dataHolder.getGenres().add(new GenreImpl(UUID.randomUUID(), name));
    }

    public Genre[] getGenres() {
        List<Genre> genres = dataHolder.getGenres();
        Genre[] genresArray = new Genre[getGenresCount()];
        for (int i = 0; i < getGenresCount(); i++) {
            genresArray[i] = genres.get(i);
        }
        return genresArray;
    }

    void deleteGenre(String name) {
        List<Genre> genres = dataHolder.getGenres();
        for (int i = 0; i < getGenresCount(); i++) {
            if (genres.get(i).getName() == name) {
                genres.remove(i);
                break;
            }
        }
    }

    //dunno how to do update and "get by smth" operations
    //still dunno where is our search-thing :D

}
