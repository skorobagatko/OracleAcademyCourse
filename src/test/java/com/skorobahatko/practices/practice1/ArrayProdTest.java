package com.skorobahatko.practices.practice1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayProdTest {

    private int[] arr;

    @Before
    public void before() {
        arr = new int[]{2, 3, 4};
    }

    @After
    public void after() {
        arr = null;
    }

    @Test
    public void prodStatic() {
        int expected = 24;
        int actual = ArrayProd.prod(arr);
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void prodStaticNullArgument() {
        ArrayProd.prod(null);
    }

    @Test
    public void prodInstance() {
        int expected = 24;
        ArrayProd multiplier = new ArrayProd(arr);
        int actual = multiplier.prod();
        assertEquals(expected, actual);
    }
}