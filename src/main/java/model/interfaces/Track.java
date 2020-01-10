package model.interfaces;

public interface Track {
    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    String getAuthor();

    void setAuthor(String author);

    String getAlbum();

    void setAlbum(String album);

    Integer getDuration();

    void setDuration(Integer duration);

    Genre getGenre();

    void setGenre(Genre genre);
}
