package com.skorobahatko.lectures.lecture2.junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @After
    public void after() {
        calculator = null;
    }

    @Test
    public void sumPositiveCase() {
        int a = 2;
        int b = 3;
        int expectedResult = 5;
        int actualResult = calculator.sum(a, b);
        assertEquals("Checking positive case", expectedResult, actualResult);
    }

    @Test(timeout = 5)
    public void sumPerformance() {
        int a = 2;
        int b = 3;
        calculator.sum(a, b);
    }

    @Test
    public void divPositive() {
        double a = 3;
        double b = 5;
        double expected = 0.6;
        double actual = calculator.div(a, b);
        assertEquals("Check divide method", expected, actual, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void divException() {
        double a = 3;
        double b = 0;
        calculator.div(a, b);
    }
}