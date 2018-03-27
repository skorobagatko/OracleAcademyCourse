package com.skorobahatko.practices.practice5;

import java.io.*;

public class WordsSwapHelper {

    public static void main(String[] args) {
        String from = "./src/main/resources/text.txt";
        String to = "./src/main/resources/text-swapped.txt";
        swapFirstAndLastWordsInFile(from, to);
    }

    public static void swapFirstAndLastWordsInFile(String from, String to) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(from), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(to), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String result = swapFirstAndLastWordsInString(line);
                writer.write(result);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String swapFirstAndLastWordsInString(String s) {
        String result = null;
        int firstWordFromIndex = 0;
        int firstWordToIndex = s.indexOf(' ');
        int lastWordFromIndex = s.lastIndexOf(' ') + 1;
        boolean isLineEndsWithPunctuationMark = false;
        char lastChar = 0;
        if (s.endsWith(".") || s.endsWith(",")) {
            lastChar = s.charAt(s.length() - 1);
            isLineEndsWithPunctuationMark = true;
        }
        int lastWordToIndex = (isLineEndsWithPunctuationMark) ? s.length()-1 : s.length();
        String firstWord = s.substring(firstWordFromIndex, firstWordToIndex);
        String lastWord = s.substring(lastWordFromIndex, lastWordToIndex);
        result = lastWord + s.substring(firstWordToIndex, lastWordFromIndex) + firstWord;
        if (isLineEndsWithPunctuationMark) {
            result += lastChar;
        }
        return result;
    }
}
