package com.dp.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author dp
 * @data 2020/7/19 - 18:21
 */
public class NIOFileChannel {
    public static void main(String[] args) throws IOException {


        String str="Hello World";
        FileOutputStream fileOutputStream = new FileOutputStream ("D:\\file01.txt");

        FileChannel channel = fileOutputStream.getChannel ();

        ByteBuffer byteBuffer = ByteBuffer.allocate (1024);

        byteBuffer.put (str.getBytes ());
        byteBuffer.flip ();
        channel.write (byteBuffer);
        fileOutputStream.close ();

    }
}
