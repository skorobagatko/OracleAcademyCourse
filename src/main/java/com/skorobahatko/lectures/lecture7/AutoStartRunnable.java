package com.skorobahatko.lectures.lecture7;

public class AutoStartRunnable implements Runnable {

    public AutoStartRunnable() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("AutoStartRunnable.run() in thread " + threadName);
        for (int i = 0; i < 10; i++) {
            System.out.println(threadName + " >>> " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
