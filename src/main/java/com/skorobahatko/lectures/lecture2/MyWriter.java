package com.skorobahatko.lectures.lecture2;

import java.io.IOException;

public class MyWriter implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new IOException("Exception in MyWriter.close()");
    }

    public void write(String to, String text) throws IOException {
        if (true) {
            throw new IOException("Exception in MyWriter.write()");
        }
        System.out.println("The text '" + text +"' is writed to file '" + to + "'");
    }
}
