package com.skorobahatko.lectures.lecture7.data_races;

public class Counter {

    public static final Object lock = new Object();
    public static volatile int counter = 0;

}
