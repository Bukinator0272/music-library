package model.interfaces;

import java.util.UUID;

public interface Track {

    UUID getId();
    void setId(UUID id);

    String getName();
    void setName(String name);

    String getAuthor();
    void setAuthor(String author);

    String getAlbum();
    void setAlbum(String album);

    String getGenre();
    void setGenre(String genre);

    long getDuration();
    void setDuration(long duration);


}
