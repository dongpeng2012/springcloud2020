package com.dp.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

/**
 * @author dp
 * @data 2020/7/19 - 18:45
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws IOException {

        //创建文件的输入流
        File file = new File ("D:\\file01.txt");
        FileInputStream fileInputStream = new FileInputStream (file);
        FileChannel channel = fileInputStream.getChannel ();

        ByteBuffer byteBuffer = ByteBuffer.allocate ((int) file.length ());
        channel.read (byteBuffer);
        System.out.println (new String (byteBuffer.array ()));
        fileInputStream.close ();

    }
}
