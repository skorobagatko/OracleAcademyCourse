package com.skorobahatko.practices.practice4;

import java.util.Objects;

public class Student {

    private String firstName;
    private String lastName;
    private int course;

    public Student() {
    }

    public Student(String firstName, String lastName, int course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", course=" + course +
                '}';
    }
}
