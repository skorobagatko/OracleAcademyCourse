package com.skorobahatko.practices.practice1.education;

import com.skorobahatko.practices.practice1.education.exception.StudentException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentTest {

    private Student student;

    @Before
    public void before() {
        Group group = new Group(Course.FIFTH, Faculty.COMPUTER_SCIENCE);
        student = new Student("John", "Johnson", group);
    }

    @After
    public void after() {
        student = null;
    }

    @Test
    public void getMaxGradeBySubjectPositiveTest() {
        Subject subject = Subject.COMPUTER_SCIENCE;
        int expected = 90;
        student.addExam(new Exam(subject, expected, Semester.EIGHT));
        student.addExam(new Exam(subject, 80, Semester.EIGHT));
        int actual = student.getMaxGradeBySubject(subject);
        assertEquals(expected, actual);
    }

    @Test
    public void addExamPositiveTest() {
        Exam exam = new Exam(Subject.COMPUTER_SCIENCE, 90, Semester.EIGHT);
        student.addExam(exam);
        assertTrue(student.getExams().contains(exam));
    }

    @Test
    public void removeExamPositiveTest() throws StudentException {
        Exam exam = new Exam(Subject.COMPUTER_SCIENCE, 90, Semester.EIGHT);
        student.addExam(exam);
        student.removeExam(exam);
        assertFalse(student.getExams().contains(exam));
    }

    @Test
    public void getExamsCountByGradePositiveTest() {
        int grade = 90;
        Exam exam1 = new Exam(Subject.CHEMISTRY, grade, Semester.FOUR);
        Exam exam2 = new Exam(Subject.COMPUTER_SCIENCE, grade, Semester.EIGHT);
        student.addExam(exam1);
        student.addExam(exam2);
        int expected = 2;
        int actual = student.getExamsCountByGrade(grade);
        assertEquals(expected, actual);
    }

    @Test
    public void getAverageGradeBySemester() {
        Semester semester = Semester.EIGHT;
        Exam exam1 = new Exam(Subject.CHEMISTRY, 60, semester);
        Exam exam2 = new Exam(Subject.COMPUTER_SCIENCE, 90, semester);
        student.addExam(exam1);
        student.addExam(exam2);
        double expected = (exam1.getGrade() + exam2.getGrade()) / 2;
        double actual = student.getAverageGradeBySemester(semester);
        assertEquals(expected, actual, 0.01);
    }
}