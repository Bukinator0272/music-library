package model.impl;

import model.interfaces.Genre;

import java.util.UUID;

public class GenreImpl implements Genre {

    private UUID id;
    private String name;

    public GenreImpl() {
    }

    public GenreImpl(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
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
}
