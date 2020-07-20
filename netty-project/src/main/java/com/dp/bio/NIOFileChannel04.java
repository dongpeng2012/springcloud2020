package com.dp.bio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class NIOFileChannel04 {

    public static void main(String[] args) throws IOException {

        //创建相关的流
        FileInputStream fileInputStream = new FileInputStream("D:\\workspaces\\springcloud2020\\netty-project\\src\\main\\resources\\头像.jpg");
        FileChannel sourceCh = fileInputStream.getChannel();

        FileOutputStream fileOutputStream=new FileOutputStream("D:\\workspaces\\springcloud2020\\netty-project\\src\\main\\resources\\a2.jpg");
        FileChannel destCh = fileOutputStream.getChannel();

        //使用transform完成拷贝；
        destCh.transferFrom(sourceCh,0,sourceCh.size());
        //关闭相关的通道
        sourceCh.close();
        destCh.close();
        fileInputStream.close();
        fileOutputStream.close();


    }

}
