package com.skorobahatko.practices.practice5;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class RandomNumberUtils {

    public static void main(String[] args) {
        String file = "./src/main/resources/numbers.txt";
        int numberOfNumbers = 10;
        saveRandomNumbersToFile(file, numberOfNumbers);

        System.out.println("Array from file:");
        System.out.println(Arrays.toString(readNumbersFromFileAndSort(file, numberOfNumbers)));
    }

    public static void saveRandomNumbersToFile(String path, int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = random.nextInt();
        }
        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(path))) {
            for (int i : arr) {
                dos.writeInt(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] readNumbersFromFileAndSort(String path, int n) {
        int[] result = null;
        try(DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
            result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = dis.readInt();
            }
            Arrays.sort(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
