package com.skorobahatko.lectures.lecture8.web;

import com.skorobahatko.lectures.lecture8.web.dto.MovieDto;
import com.skorobahatko.lectures.lecture8.web.service.api.Service;
import com.skorobahatko.lectures.lecture8.web.service.impl.MovieServiceImpl;

public class App {
    public static void main(String[] args) {
        MovieDto movieDto = new MovieDto("Matrix", "Not bad", 112L);
        Service<Integer, MovieDto> service = MovieServiceImpl.getInstance();
        service.save(movieDto);
        service.getAll().forEach(System.out::println);
    }
}
