package com.skorobahatko.lectures.lecture7;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread.run() in thread " + getName());
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " --> " + i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
