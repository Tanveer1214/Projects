package com.temp;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArray_Input_Stream {
    public static void main(String[] args) throws IOException {

        byte[] bytes = {65,66,67,68,69,70};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

        int i = byteArrayInputStream.read();
        while(i != -1) {
            System.out.print((char) i);
            i = byteArrayInputStream.read();
        }
        
        byteArrayInputStream.close();

    }
}

/*
A ByteArrayInputStream contains
an internal buffer that contains bytes that
may be read from the stream. An internal
counter keeps track of the next byte to
be supplied by the read method.

Closing a ByteArrayInputStream has no effect. The methods in
this class can be called after the stream has been closed without
generating an IOException.
 */