package com.skorobahatko.lectures.lecture7.data_races;

public class MyThread extends Thread {

    @Override
    public void run() {
        incrementCounter();
        incrementCounter();
        incrementCounter();
    }

    private void incrementCounter() {
        synchronized (Counter.lock) {
            Counter.counter++;
            System.out.println(Counter.counter);
        }
    }
}
