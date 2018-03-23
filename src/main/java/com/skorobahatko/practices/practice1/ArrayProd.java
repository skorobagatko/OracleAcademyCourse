package com.skorobahatko.practices.practice1;

import java.util.Arrays;

public class ArrayProd {

    private int[] arr;

    public ArrayProd() {
    }

    public ArrayProd(int[] arr) {
        this.arr = arr;
    }

    public static int prod(int[] arr) {
        return Arrays.stream(arr).reduce((x,y) -> x*y).getAsInt();
    }

    public int prod() {
        return Arrays.stream(arr).reduce((x,y) -> x*y).getAsInt();
    }
}
