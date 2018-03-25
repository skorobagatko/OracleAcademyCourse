package com.skorobahatko.practices.practice4;

import java.io.*;
import java.util.*;

public class TextUtils {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> wordsMap = getWordsWithCounting("D:\\\\lorem-ipsum.txt", SortType.BY_ALPHABET);
        wordsMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    public static Map<String, Integer> getWordsWithCounting(String file) throws IOException {
        Map<String, Integer> wordsMap = new HashMap<>();
        String text = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            StringBuilder sb = new StringBuilder();
            while (br.ready()) {
                sb.append(br.readLine());
            }
            text = sb.toString();
        }
        String[] words = text.split("[ .,]+");
        Arrays.stream(words).forEach(w -> wordsMap.merge(w, 1, Integer::sum));
        return wordsMap;
    }

    public  static Map<String, Integer> getWordsWithCounting(String file, SortType sortType) throws IOException {
        Comparator<String> comparator = null;
        if(sortType == SortType.BY_ALPHABET) {
            comparator = Comparator.naturalOrder();
        } else if(sortType == SortType.BY_LENGTH) {
            comparator = Comparator.comparingInt(String::length);
        }
        Map<String, Integer> sortedWordsMap = new TreeMap<>(comparator);
        sortedWordsMap.putAll(getWordsWithCounting(file));
        return sortedWordsMap;
    }
}
