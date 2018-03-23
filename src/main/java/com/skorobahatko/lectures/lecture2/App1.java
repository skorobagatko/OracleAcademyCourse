package com.skorobahatko.lectures.lecture2;

public class App1 {
    public static void main(String[] args) {
        copyFile("src.txt", "dst.txt");
    }

    public static void copyFile(String from, String to) {
        try (MyReader myReader = new MyReader();
             MyWriter myWriter = new MyWriter()) {
            myWriter.write(to, myReader.read(from));
        } catch (Exception e) {
            e.addSuppressed(new RuntimeException("Suppressed RuntimeException"));
            e.printStackTrace();
        }
    }
}
