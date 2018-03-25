package com.skorobahatko.practices.practice4;

import java.util.*;

public class StudentUtils {

    public static Map<String, Student> createMapFromList(List<Student> students) {
        Map<String, Student> studentMap = new HashMap<>();
        students.forEach(s -> studentMap.put(s.getFirstName() + " " + s.getLastName(), s));
        return studentMap;
    }

    public static void printStudentsIter(List<Student> students, int course) {
        Iterator<Student> iter = students.iterator();
        while(iter.hasNext()) {
            Student s = iter.next();
            if (s.getCourse() == course) {
                System.out.println(s.getFirstName() + " " + s.getLastName());
            }
        }
    }

    public static void printStudentsLambda(List<Student> students, int course) {
        students.stream()
                .filter(s -> s.getCourse() == course)
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
    }

    public static List<Student> sortStudents(List<Student> students) {
        students.sort(Comparator.comparing(Student::getFirstName));
        return students;
    }
}
