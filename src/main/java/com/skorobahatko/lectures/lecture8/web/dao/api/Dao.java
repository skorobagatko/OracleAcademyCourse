package com.skorobahatko.lectures.lecture8.web.dao.api;

import com.skorobahatko.lectures.lecture8.web.entity.Entity;

import java.util.List;

public interface Dao<K, T extends Entity<K>> {

    List<T> getAll();
    T getById(K id);
    void save(T entity);
    void delete(K id);
    void update(T entity);

}
