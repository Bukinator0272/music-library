package model.dbservice.dao;

import model.dbservice.executor.Executor;
import model.impl.GenreImpl;
import model.interfaces.Genre;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {

    private Executor executor;

    public GenreDAO(Connection connection) throws SQLException {
        this.executor = new Executor(connection);
    }

    private boolean isExist(Genre genre) throws SQLException {
        if (genre == null || genre.getId() == null)
            return false;
        return existById(genre.getId());
    }

    private boolean existById(Long id) throws SQLException {
        return executor.execQuery(result -> result.next(), "select * from genre where id = ? ", id.toString());
    }

    public Genre get(Long id) throws SQLException {
        return executor.execQuery(result -> {
            if (!result.next())
                return null;
            return new GenreImpl(result.getLong(1), result.getString(2));
        }, "select * from genre where id=?", id.toString());
    }

    public List<Genre> getAll() throws SQLException {
        return executor.execQuery("select * from genre", result -> {
            List<Genre> genres = new ArrayList<>();
            while (result.next()) {
                genres.add(new GenreImpl(result.getLong(1), result.getString(2)));
            }
            return genres;
        });
    }

    public void delete(Long id) throws SQLException {
        executor.execUpdate("delete from genre where id=?", id.toString());
    }

    public void delete(Genre genre) throws SQLException {
        executor.execUpdate("delete from genre where id=?", genre.getId().toString());
    }

    public void update(Genre genre) throws SQLException {
        executor.execUpdate("update genre set name=? where id =?", genre.getName(), genre.getId().toString());
    }

    public void insert(Genre genre) throws SQLException {
        genre.setId(executor.execUpdate(resultSet -> {
                    resultSet.next();
                    return resultSet.getLong(1);
                },
                "insert into genre (name) values (?)", genre.getName()));
    }

    public void save(Genre genre) throws SQLException {
        if (isExist(genre)) {
            update(genre);
        } else insert(genre);
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists genre (id bigint(20) auto_increment, name varchar(256), primary key (id))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table genre");
    }
}
