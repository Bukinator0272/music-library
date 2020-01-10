package model.impl;

import model.interfaces.Genre;

public class GenreImpl implements Genre {

    private Long id;
    private String name;

    public GenreImpl(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreImpl(String name) {
        this.name = name;
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
    public String toString() {
        return name;
    }
}
