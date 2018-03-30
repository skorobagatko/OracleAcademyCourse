package com.skorobahatko.lectures.lecture8.web.service.impl;

import com.skorobahatko.lectures.lecture8.web.dao.DaoFactory;
import com.skorobahatko.lectures.lecture8.web.dao.api.Dao;
import com.skorobahatko.lectures.lecture8.web.dto.MovieDto;
import com.skorobahatko.lectures.lecture8.web.entity.Movie;
import com.skorobahatko.lectures.lecture8.web.mapper.BeanMapper;
import com.skorobahatko.lectures.lecture8.web.service.api.Service;

import java.util.List;

public class MovieServiceImpl implements Service<Integer, MovieDto> {

    private static MovieServiceImpl instance;

    private Dao<Integer, Movie> movieDao;

    private MovieServiceImpl() {
        movieDao = DaoFactory.getInstance().getMovieDao();
        BeanMapper.getInstance();
    }

    public static synchronized MovieServiceImpl getInstance() {
        if (instance == null) {
            instance = new MovieServiceImpl();
        }
        return instance;
    }

    @Override
    public List<MovieDto> getAll() {
        return BeanMapper.mapListToList(movieDao.getAll(), MovieDto.class);
    }

    @Override
    public MovieDto getById(Integer id) {
        return BeanMapper.singleMapper(movieDao.getById(id), MovieDto.class);
    }

    @Override
    public void save(MovieDto entity) {
        movieDao.save(BeanMapper.singleMapper(entity, Movie.class));
    }

    @Override
    public void delete(Integer id) {
        movieDao.delete(id);
    }

    @Override
    public void update(MovieDto entity) {
        movieDao.update(BeanMapper.singleMapper(entity, Movie.class));
    }
}
