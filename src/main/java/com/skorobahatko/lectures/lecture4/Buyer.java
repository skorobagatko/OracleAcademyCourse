package com.skorobahatko.lectures.lecture4;

import java.util.ArrayList;
import java.util.List;

public class Buyer<T> {

    private String name;
    private int age;
    private List<T> basket = new ArrayList<>();

    public <S> String printArray(S[] arr) {
        StringBuilder sb = new StringBuilder();
        for (S s : arr) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }

    public Buyer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addToBasket(T product) {
        basket.add(product);
    }

    public T getFromBasket(int index) {
        return basket.get(index);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
