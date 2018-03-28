package com.skorobahatko.lectures.lecture7.wait_set;

public class ChessMan implements Runnable {

    private String name;
    private Color color;
    private Clock clock;

    public ChessMan(String name, Color color, Clock clock) {
        this.name = name;
        this.color = color;
        this.clock = clock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            move();
        }
    }

    public void move() {
        synchronized (clock) {
            if (clock.getCurrentColor() != color) {
                clock.setCurrentColor(color);
                System.out.println(name + " move with " + color);
                try {
                    clock.notifyAll();
                    clock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    clock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }
}
