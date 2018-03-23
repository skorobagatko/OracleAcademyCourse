package com.skorobahatko.practices.practice2;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        HTMLNameParser parser = new HTMLNameParser("D:\\names.txt");
        String regex = "<td>(?<rank>\\d+)<\\/td>.*?<td>(?<maleName>[a-zA-z]+?)<\\/td>.*?<td>(?<femaleName>[a-zA-z]+?)<\\/td>";
        parser.parse(regex).forEach(System.out::println);
    }

}
