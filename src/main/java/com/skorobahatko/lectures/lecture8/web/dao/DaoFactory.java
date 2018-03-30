package com.skorobahatko.lectures.lecture8.web.dao;

import com.skorobahatko.lectures.lecture8.web.dao.api.Dao;
import com.skorobahatko.lectures.lecture8.web.dao.impl.MovieDaoImpl;
import com.skorobahatko.lectures.lecture8.web.entity.Movie;
import com.skorobahatko.lectures.lecture8.web.utils.PropertyUtils;

public class DaoFactory {

    private static DaoFactory instance;

    private Dao<Integer, Movie> movieDao = MovieDaoImpl.getInstance();

    private DaoFactory() {
        loadDao();
    }

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public Dao<Integer, Movie> getMovieDao() {
        return movieDao;
    }

    public void setMovieDao(Dao<Integer, Movie> movieDao) {
        this.movieDao = movieDao;
    }

    private void loadDao() {
        if (PropertyUtils.getInstance().isInMemoryDB()) {

        } else {
            movieDao = MovieDaoImpl.getInstance();
        }
    }
}
