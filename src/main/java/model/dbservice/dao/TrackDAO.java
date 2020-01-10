package model.dbservice.dao;

import model.dbservice.executor.Executor;
import model.impl.TrackImpl;
import model.interfaces.Genre;
import model.interfaces.Track;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrackDAO {

    private Executor executor;
    Connection connection;

    public TrackDAO(Connection connection) throws SQLException {
        this.executor = new Executor(connection);
        this.connection = connection;
    }

    private boolean isExist(Track track) throws SQLException {
        if (track == null || track.getId() == null)
            return false;
        return existById(track.getId());
    }

    private boolean existById(Long id) throws SQLException {
        return executor.execQuery(result -> result.next(), "select * from track where id = ? ", id.toString());
    }

    public void save(Track genre) throws SQLException {
        if (isExist(genre)) {
            update(genre);
        } else insert(genre);
    }

    public Track get(Long id) throws SQLException {
        return executor.execQuery(result -> {
            result.next();
            String name = result.getString(2);
            String author = result.getString(3);
            Integer duration = result.getInt(4);
            String album = result.getString(5);
            Long genreId = result.getLong(6);

            GenreDAO genreDAO = new GenreDAO(connection);
            Genre genre = genreDAO.get(genreId);

            Track track = new TrackImpl(id, name, author, album, genre, duration);
            return track;
        }, "select * from track where id=?", id.toString());
    }

    public List<Track> getAll() throws SQLException {
        return executor.execQuery("select * from track", result -> {
            List<Track> tracks = new ArrayList<>();
            while (result.next()) {
                Long id = result.getLong(1);
                String name = result.getString(2);
                String author = result.getString(3);
                Integer duration = result.getInt(4);
                String album = result.getString(5);
                Long genreId = result.getLong(6);

                GenreDAO genreDAO = new GenreDAO(connection);
                Genre genre = genreDAO.get(genreId);

                Track track = new TrackImpl(id, name, author, album, genre, duration);
                tracks.add(track);
            }
            return tracks;
        });
    }

    public void delete(Long id) throws SQLException {
        executor.execUpdate("delete from track where id=?", id.toString());
    }

    public void delete(Track track) throws SQLException {
        delete(track.getId());
    }

    public void update(Track track) throws SQLException {
        String id = track.getId().toString();
        String name = track.getName();
        String author = track.getAuthor();
        String duration = track.getDuration().toString();
        String album = track.getAlbum();
        String genreId = track.getGenre() != null ? track.getGenre().getId().toString() : null;

        executor.execUpdate("update track set name=?, author=?, duration=?, album=?, genre_id=?  where id =?",
                name, author, duration, album, genreId, id);
    }

    public void insert(Track track) throws SQLException {

        String name = track.getName();
        String author = track.getAuthor();
        Integer duration = track.getDuration();
        String album = track.getAlbum();
        String genreId = track.getGenre() != null ? track.getGenre().getId().toString() : null;


        track.setId(executor.execUpdate(resultSet -> {
                    resultSet.next();
                    return resultSet.getLong(1);
                },
                "insert into track (name, author, duration, album, genre_id) values (?,?,?,?,?)",
                name, author, duration.toString(), album, genreId));
    }

//    public void createTable() throws SQLException {
//        executor.execUpdate("create table if not exists genre (id int auto_increment, name varchar(256), primary key (id))");
//    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table track");
    }
}
