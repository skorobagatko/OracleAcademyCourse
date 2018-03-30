package com.skorobahatko.lectures.lecture8.web.entity;

import java.util.Objects;

public class Entity<T> {

    private T id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity<?> entity = (Entity<?>) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
