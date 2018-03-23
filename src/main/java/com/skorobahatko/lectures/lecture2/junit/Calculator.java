package com.skorobahatko.lectures.lecture2.junit;

public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public double div(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }
}
