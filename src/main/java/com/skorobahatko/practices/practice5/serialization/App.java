package com.skorobahatko.practices.practice5.serialization;

public class App {

    public static void main(String[] args) {
        Student student1 = new Student("John", 21);
        Student student2 = new Student("Bob", 23);

        Group group1 = new Group();
        group1.addStudent(student1);
        group1.addStudent(student2);
        System.out.println(group1);

        String path = "./src/main/resources/objects";
        GroupSerializer.serializeGroup(path, group1);

        Group group2 = GroupSerializer.getGroup(path);
        System.out.println(group2);
        System.out.println("group1.equals(group2) == " + (group1.equals(group2)));
    }

}
