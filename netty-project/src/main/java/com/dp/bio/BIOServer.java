package com.dp.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        //线程池机制

        //思路
        //1.创建一个线程池
        //2.如果有客户端连接，就创建一个线程，与之通讯（单独写一个方法）
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        //创建serverSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了！！！！！！");
        while (true){
            //进行监听，等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            newCachedThreadPool.execute(new Runnable() {
                public void run() {//我们重写
                    //可以和客户端通讯
                    handler(socket);
                }
            });

        }
    }
    //编写一个handler方法和客户端通讯
    public static void handler(Socket socket){

        byte[] bytes = new byte[1024];
        //通过socket获取输入流
        try {
            InputStream inputStream = socket.getInputStream();
            while (true) {
                int read = inputStream.read(bytes);
                if (read!=-1){
                    System.out.println(new String(bytes,0,read));//输出客户端发出的数据
                }else {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            System.out.println("关闭和client的连接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
