package com.dp.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author dp
 * @data 2020/7/23 - 23:26
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile ("1.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel ();

        MappedByteBuffer buffer = channel.map (FileChannel.MapMode.READ_WRITE, 0, 5);
        buffer.put (0,(byte) 'H');

    }


}
