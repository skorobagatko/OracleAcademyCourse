package com.skorobahatko.practices.practice5;

import java.io.*;

public class CopyFilePerformanceMeter {

    public static void main(String[] args) {
        String from = "./src/main/resources/lorem";
        String to = "./src/main/resources/lorem-copy";

        long nonBufferedMethod = getNonBufferedFileCopyPerformance(from, to);
        System.out.println("Non buffered method work time: " + nonBufferedMethod + " ms");

        long bufferedMethod = getBufferedFileCopyPerformance(from, to);
        System.out.println("Buffered method work time: " + bufferedMethod + " ms");
    }

    public static long getNonBufferedFileCopyPerformance(String from, String to) {
        long result = 0L;
        try (FileInputStream in = new FileInputStream(from);
             FileOutputStream out = new FileOutputStream(to)) {
            int b = -1;
            long startTime = System.currentTimeMillis();
            while ((b = in.read()) != -1) {
                out.write(b);
            }
            long endTime = System.currentTimeMillis();
            result = endTime - startTime;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static long getBufferedFileCopyPerformance(String from, String to) {
        long result = 0L;
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(from));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(to))) {
            byte[] buff = new byte[1024];
            int counter = 0;
            long startTime = System.currentTimeMillis();
            while ((counter = in.read(buff)) != -1) {
                out.write(buff, 0, counter);
            }
            long endTime = System.currentTimeMillis();
            result = endTime - startTime;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
