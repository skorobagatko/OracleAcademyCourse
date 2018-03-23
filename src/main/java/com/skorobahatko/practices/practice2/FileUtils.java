package com.skorobahatko.practices.practice2;

import java.io.*;

public class FileUtils {

    public static String getFileContentAsString(String file) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), "UTF-8"))) {
            StringBuilder sb = new StringBuilder();
            while (br.ready()) {
                sb.append(br.readLine());
            }
            return sb.toString();
        }
    }
}
