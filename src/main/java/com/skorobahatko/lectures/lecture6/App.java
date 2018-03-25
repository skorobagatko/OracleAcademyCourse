package com.skorobahatko.lectures.lecture6;

import java.io.*;

public class App {
    public static void main(String[] args) {
        copyText("./src/main/resources/text.txt", "./src/main/resources/textCopy.txt", "UTF-8", "windows-1251");
    }

    private static void copyText(String src, String dst, String srcCharset, String dstCharset) {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(src), srcCharset);
             OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(dst), dstCharset)) {
            while (reader.ready()) {
                writer.write(reader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
