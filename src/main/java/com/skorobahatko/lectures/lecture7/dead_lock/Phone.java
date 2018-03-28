package com.skorobahatko.lectures.lecture7.dead_lock;

public class Phone {

    private int number;

    public Phone(int number) {
        this.number = number;
    }

    public synchronized void call(Phone phone) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The phone " + number + " is calling " + phone.getNumber());
        phone.receiveCall(this);
    }

    public synchronized void receiveCall(Phone phone) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The phone " + number + " is receive call from phone " + phone.getNumber());

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number=" + number +
                '}';
    }
}
