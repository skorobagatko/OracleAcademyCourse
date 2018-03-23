package com.skorobahatko.practices.practice1.education;

import com.skorobahatko.practices.practice1.education.exception.StudentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {

    private String firstName;
    private String lastName;
    private Group group;
    private List<Exam> exams;

    public Student() {
    }

    public Student(String firstName, String lastName, Group group) {
        this(firstName, lastName, group, null);
    }

    public Student(String firstName, String lastName, Group group, List<Exam> exams) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.exams = exams;
    }

    public int getMaxGradeBySubject(Subject subject) {
        return exams.stream()
                .filter(e -> e.getSubject() == subject)
                .mapToInt(Exam::getGrade)
                .max()
                .orElse(-1);
    }

    public void addExam(Exam exam) {
        if (exams == null) {
            exams = new ArrayList<>();
        }
        exams.add(exam);
    }

    public void removeExam(Exam exam) throws StudentException {
        if (exams == null) {
            throw new StudentException("The student's list of exams is empty");
        }
        if (!exams.remove(exam)) {
            throw new StudentException("The student doesn't nave this exam in the list of exams");
        }
    }

    public int getExamsCountByGrade(int grade) {
        return (int) exams.stream()
                .filter(e -> e.getGrade() == grade)
                .count();
    }

    public double getAverageGradeBySemester(Semester semester) {
        double sum = 0.0;
        int examsCounter = 0;
        for (Exam exam : exams) {
            if (exam.getSemester() == semester) {
                examsCounter++;
                sum += exam.getGrade();
            }
        }
        return sum / examsCounter;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(group, student.group) &&
                Objects.equals(exams, student.exams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, group, exams);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group=" + group +
                ", exams=" + exams +
                '}';
    }
}
