package com.skorobahatko.lectures.lecture1;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Circle {

    private Point point;

    private int superSecretCode = 1234;

    public Circle(int x, int y) {
        point = new Point();
        point.x = x;
        point.y = y;
    }

    @Data
    public class Point {
        private int x;
        private int y;

        public int getSuperSecretCode() {
            return superSecretCode;
        }
    }
}
