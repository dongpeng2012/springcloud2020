package com.dp.bio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("D:\\workspaces\\springcloud2020\\netty-project\\src\\main\\resources\\timg.jpg");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\workspaces\\springcloud2020\\netty-project\\src\\main\\resources\\t.jpg");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true){

            byteBuffer.clear();//   清空buffer

            int read = fileChannel01.read(byteBuffer);

            if (read==-1){
                break;
            }
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
            //关闭相关的流


        }
        fileInputStream.close();
        fileOutputStream.close();
    }


}
