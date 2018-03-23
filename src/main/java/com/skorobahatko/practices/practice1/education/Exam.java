package com.skorobahatko.practices.practice1.education;

import java.util.Objects;

public class Exam {

    private Subject subject;
    private int grade;
    private Semester semester;

    public Exam(Subject subject, int grade, Semester semester) {
        this.subject = subject;
        this.grade = grade;
        this.semester = semester;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return grade == exam.grade &&
                subject == exam.subject &&
                semester == exam.semester;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, grade, semester);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "subject=" + subject +
                ", grade=" + grade +
                ", semester=" + semester +
                '}';
    }
}
