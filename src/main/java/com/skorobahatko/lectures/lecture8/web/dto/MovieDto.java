package com.skorobahatko.lectures.lecture8.web.dto;

import com.skorobahatko.lectures.lecture8.web.entity.Entity;

import java.util.Objects;

public class MovieDto extends Entity<Integer> {

    private String title;
    private String description;
    private Long duration;

    public MovieDto() {
    }

    public MovieDto(String title, String description, Long duration) {
        this.title = title;
        this.description = description;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MovieDto movie = (MovieDto) o;
        return Objects.equals(title, movie.title) &&
                Objects.equals(description, movie.description) &&
                Objects.equals(duration, movie.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, description, duration);
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                '}';
    }
}
