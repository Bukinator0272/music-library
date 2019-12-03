package model.interfaces;

import java.util.UUID;

public interface Genre {

    UUID getId();
    void setId(UUID id);

    String getName();
    void setName(String name);


}
