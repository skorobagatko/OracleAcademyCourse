package com.skorobahatko.lectures.lecture7;

public class AutoStartThread extends Thread {

    public AutoStartThread() {
        start();
    }

    @Override
    public void run() {
        System.out.println("AutoStartThread.run() in thread " + getName());
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " <<< " + i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
