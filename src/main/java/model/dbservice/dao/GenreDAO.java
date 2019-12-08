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

    public GenreDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public Genre get(Long id) throws SQLException {
        return executor.execQuery(result -> {
            result.next();
            return new GenreImpl(result.getLong(1), result.getString(2));
        },"select * from genre where id=?",id.toString());
    }

    public List<Genre> getAll() throws SQLException {
        return executor.execQuery("select * from genre", result -> {
            List<Genre> genres = new ArrayList<>();
            while (!result.isLast()){
                result.next();
                new GenreImpl(result.getLong(1), result.getString(2));
            }
            return genres;
        });
    }

    public void delete(Long id) throws SQLException {
        executor.execUpdate("delete from genre where id=?",id.toString());
    }

    public void update(Genre genre) throws SQLException {
        executor.execUpdate("update genre set name=? where id =?",genre.getName(), genre.getId().toString());
    }

    public void insert(Genre genre) throws SQLException {
        genre.setId(executor.execUpdate(resultSet -> resultSet.getLong(1),
                "insert into genre (name) values (?)", genre.getName()));
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists genre (id int auto_increment, name varchar(256), primary key (id))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table genre");
    }
}
