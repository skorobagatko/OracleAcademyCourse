package com.skorobahatko.lectures.lecture8.web.dao.impl;

import com.skorobahatko.lectures.lecture8.web.entity.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl extends CrudDao<Movie> {

    private static final String SQL_INSERT_MOVIE = "INSERT INTO movie (title, duration, description) VALUES (?, ?, ?);";
    private static final String SQL_UPDATE_MOVIE = "UPDATE movie SET title = ?, duration = ?, description = ? WHERE id = ?";

    private static MovieDaoImpl instance;

    private MovieDaoImpl(Class type) {
        super(type);
    }

    public static synchronized MovieDaoImpl getInstance() {
        if (instance == null) {
            instance = new MovieDaoImpl(Movie.class);
        }
        return instance;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection conn, Movie entity) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE_MOVIE);
            ps.setString(1, entity.getTitle());
            ps.setLong(2, entity.getDuration());
            ps.setString(3, entity.getDescription());
            ps.setInt(4, entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection conn, Movie entity) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT_MOVIE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getTitle());
            ps.setLong(2, entity.getDuration());
            ps.setString(3, entity.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public List<Movie> readAll(ResultSet resultSet) {
        List<Movie> result = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDescription(resultSet.getString("description"));
                movie.setDuration(resultSet.getLong("duration"));
                result.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
