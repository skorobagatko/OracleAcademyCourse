package com.skorobahatko.lectures.lecture7;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("MyRunnable.run() in runnable " + threadName);
        for (int i = 0; i < 10; i++) {
            System.out.println(threadName + " *** " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
