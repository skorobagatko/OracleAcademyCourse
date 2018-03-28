package com.skorobahatko.lectures.lecture7.wait_set;

public class Clock {

    private Color currentColor = Color.BLACK;

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }
}
