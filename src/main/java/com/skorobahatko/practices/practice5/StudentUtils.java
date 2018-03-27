package com.skorobahatko.practices.practice5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentUtils {

    public static void main(String[] args) {
        String path = "./src/main/resources/students";
        System.out.println(getHighGradeStudentsFromFile(path));
    }

    public static List<Student> getHighGradeStudentsFromFile(String path) {
        List<Student> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line = null;
            while((line = br.readLine()) != null) {
                String[] studentFields = line.split("=");
                int averageScore = Integer.parseInt(studentFields[1]);
                if (averageScore >= 90) {
                    String name = studentFields[0];
                    Student student = new Student(name, averageScore);
                    result.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
