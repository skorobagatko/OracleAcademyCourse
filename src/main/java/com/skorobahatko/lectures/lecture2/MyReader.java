package com.skorobahatko.lectures.lecture2;

import java.io.IOException;

public class MyReader implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new IOException("Exception in MyReader.close()");
    }

    public String read(String from) {
        return "String";
    }
}
