package com.skorobahatko.lectures.lecture5;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Set<Human> humanSet = new HashSet<>();
        humanSet.add(new Human("Vasya", 20));
        humanSet.add(new Human("Petya", 10));
        humanSet.add(new Human("Kolya", 40));
        humanSet.add(new Human("Kolya", 40));
        humanSet.forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Set<Human> humanSet1 = new TreeSet<>(humanSet);
        humanSet1.forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Map<String, Human> humanMap = new HashMap<>();
        humanSet1.forEach(h -> humanMap.put(h.getName(), h));

        humanMap.forEach((s, h) -> System.out.println(s + " : " + h));
    }
}
