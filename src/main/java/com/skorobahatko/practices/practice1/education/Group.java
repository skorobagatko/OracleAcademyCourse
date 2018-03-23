package com.skorobahatko.practices.practice1.education;

import java.util.Objects;

public class Group {

    private Course course;
    private Faculty faculty;

    public Group(Course course, Faculty faculty) {
        this.course = course;
        this.faculty = faculty;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return course == group.course &&
                faculty == group.faculty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, faculty);
    }

    @Override
    public String toString() {
        return "Group{" +
                "course=" + course +
                ", faculty=" + faculty +
                '}';
    }
}
