package com.skorobahatko.lectures.lecture4;

public class Human<T> {

    private String name;
    private T instance;
    private Class<T> clazz;

    public Human(String name, Class<T> clazz) {
        this.name = name;
        this.clazz = clazz;
        try {
            instance = (T) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
