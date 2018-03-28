package com.skorobahatko.lectures.lecture7.data_races;

public class App {

    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();

        t1.start();
        t2.start();
        t3.start();
    }
}
