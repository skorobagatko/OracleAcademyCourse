package com.skorobahatko.practices.practice1;

import java.util.Arrays;

public class ArraySum {

    private int[] arr;

    public ArraySum() {
    }

    public ArraySum(int[] arr) {
        this.arr = arr;
    }

    public static int sum(int[] arr) {
        if (arr == null) {
            throw new NullPointerException("Array must be not null");
        }
        return Arrays.stream(arr).sum();
    }

    public static int min(int[] arr) {
        return Arrays.stream(arr).min().getAsInt();
    }

    public static int max(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    public int sum() {
        return Arrays.stream(arr).sum();
    }
}
