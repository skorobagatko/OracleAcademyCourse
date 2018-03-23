package com.skorobahatko.lectures.lecture4;

public class Human<T> {

    private String name;
    private T instance;
    private Class<T> clazz;
    private T[] arr;

    public Human(String name, Class<T> clazz) {
        this.name = name;
        this.clazz = clazz;
        try {
            instance = (T) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
