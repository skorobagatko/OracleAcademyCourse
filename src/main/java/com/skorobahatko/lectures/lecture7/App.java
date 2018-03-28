package com.skorobahatko.lectures.lecture7;

public class App {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start of main() in thread " + Thread.currentThread().getName());

        MyThread myThread0 = new MyThread();
        MyThread myThread1 = new MyThread();

        Thread myThread2 = new Thread(new MyRunnable());
        Thread myThread3 = new Thread(new MyRunnable());

//        AutoStartRunnable myThread4 = new AutoStartRunnable();
//        AutoStartThread myThread5 = new AutoStartThread();

        Thread myThread4 = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("MyRunnable.run() in runnable " + threadName);
            for (int i = 0; i < 30; i++) {
                System.out.println(threadName + " *** " + i);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
            System.out.println("Lambda runnable implementation");});

        myThread0.start();
        myThread1.start();
        myThread2.start();
        myThread3.start();

        myThread4.setName("Daemon");
        myThread4.setDaemon(true);
        myThread4.start();

        myThread0.join();
        myThread1.join();
        myThread2.join();
        myThread3.join();

        System.out.println("End of main() in thread " + Thread.currentThread().getName());
    }
}
