package controller;

import model.impl.TrackImpl;
import model.interfaces.Track;
import service.DataHolder;
import java.util.List;
import java.util.UUID;

public class TrackController {

    private DataHolder dataHolder;

    public int getTracksCount() {
        return dataHolder.getTracksCount();
    }

    void addTrack(String name, String author, String album, String genre, long duration) {
        dataHolder.getTraks().add(new TrackImpl(UUID.randomUUID(), name, author, album, genre, duration));
    }

    public Track[] getTracks() {
        List<Track> tracks = dataHolder.getTraks();
        Track[] tracksArray = new Track[getTracksCount()];
        for (int i = 0; i < getTracksCount(); i++) {
            tracksArray[i] = tracks.get(i);
        }
        return tracksArray;
    }

    void deleteTrack(String name) {
        List<Track> albums = dataHolder.getTraks();
        for (int i = 0; i < getTracksCount(); i++) {
            if (albums.get(i).getName() == name) {
                albums.remove(i);
                break;
            }
        }
    }

    //dunno how to do update and "get by smth" operations
    //still dunno where is our search-thing :D

}
