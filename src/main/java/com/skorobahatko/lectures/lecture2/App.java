package com.skorobahatko.lectures.lecture2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        String s = readStringFromConsole();
        System.out.println(s);
    }

    private static String readStringFromConsole() {
        String result = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            result = br.readLine();
            return result;
        } catch (IOException e) {
            return e.getLocalizedMessage();
        } finally {
            return "Finally";
        }
    }
}