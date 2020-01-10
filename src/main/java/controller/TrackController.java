package controller;

import model.interfaces.Track;
import service.DataHolder;

import java.sql.SQLException;
import java.util.List;

public class TrackController {

    private DataHolder dataHolder;

    public TrackController() {
        this.dataHolder = SharedController.getInstance().getDataHolder();
    }

    public void addTrack(String name, String author, String album, String genre, int duration) {
        dataHolder.addTrack(name, author, album, genre, duration);
    }

    public List<Track> getTracks() throws SQLException {
        return dataHolder.getTracks();
    }

    public void saveTrack(Track track) throws SQLException {
        dataHolder.saveTrack(track);
    }

    public void deleteTrack(Track track) throws SQLException {
        dataHolder.removeTrack(track);
    }
}
