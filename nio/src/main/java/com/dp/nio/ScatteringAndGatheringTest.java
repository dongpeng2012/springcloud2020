package com.dp.nio;

/**
 * @author dp
 * @data 2020/7/24 - 23:35
 */

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * scattering:将数据写入到buffer时，可以采用buffer数组，一词写入
 *  Gathering:从buffer读取数据时,可以采用buffer数组,依次读
 *
 */
public class ScatteringAndGatheringTest {
    public static void main(String[] args) throws IOException {

        //使用serverSocketChannel和SocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open ();
        InetSocketAddress inetSocketAddress = new InetSocketAddress (7000);

        //绑定端口并启动
        serverSocketChannel.socket ().bind (inetSocketAddress);

        //创建buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate (5);
        byteBuffers[1] = ByteBuffer.allocate (3);

        //等待客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept ();

        int messageLength = 8;
        while (true){
            int byteRead = 0;
            while (byteRead<messageLength){
                long l = socketChannel.read (byteBuffers);
                byteRead += l;//累计读取的字节数
                System.out.println ("byteRead="+byteRead);
                //使用流打印看看当前这个buffer的position和limit
                Arrays.asList (byteBuffers).stream ()
                        .map (byteBuffer->"position="+byteBuffer.position ()+"limit="+byteBuffer.limit ()).forEach (System.out::println);
            }
            //将所有的buffer进行flip
            Arrays.asList (byteBuffers).stream ().forEach (byteBuffer -> byteBuffer.flip ());

            //将数据读出显示到客户端
            long byteWrite = 0;
            while (byteWrite<messageLength){
                long l = socketChannel.write (byteBuffers);
                byteWrite += l;
            }
            //将所有的buffer进行clean
            Arrays.asList (byteBuffers).stream ().forEach (byteBuffer -> byteBuffer.clear ());
            System.out.println ("byteRead="+byteRead+"byteWrite"+byteWrite+"*****"messageLength);
        }


    }
}
