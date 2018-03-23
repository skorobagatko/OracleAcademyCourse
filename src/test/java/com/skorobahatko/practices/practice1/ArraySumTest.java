package com.skorobahatko.practices.practice1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ArraySumTest {

    private int[] arr;

    @Before
    public void before() {
        arr = new int[]{1, 2, 3};
    }

    @After
    public void after() {
        arr = null;
    }

    @Test
    public void sumStatic() {
        int expected = 6;
        int actual = ArraySum.sum(arr);
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void sumStaticWithNullArgument() {
        int actual = ArraySum.sum(null);
    }

    @Test
    public void minStatic() {
        int expected = 1;
        int actual = ArraySum.min(arr);
        assertEquals(expected, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void minStaticZeroLengthArray() {
        int actual = ArraySum.min(new int[0]);
    }

    @Test
    public void maxStatic() {
        int expected = 3;
        int actual = ArraySum.max(arr);
        assertEquals(expected, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void maxStaticZeroLengthArray() {
        int actual = ArraySum.max(new int[0]);
    }

//    @Test
//    public void sumInstance() {
//        int expected = 6;
//        ArraySum summator = new ArraySum(arr);
//        int actual = summator.sum();
//        assertEquals(expected, actual);
//    }
}