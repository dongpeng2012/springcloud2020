package com.dp.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author dp
 * @data 2020/7/26 - 23:43
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        //创建
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open ();
        //得到一个selector对象
        Selector selector = Selector.open ();
        //绑定端口6666在服务器端监听
        serverSocketChannel.socket ().bind (new InetSocketAddress (6666));
        //设置非阻塞模式
        serverSocketChannel.configureBlocking (false);
        //把serverSocketChannel注册到selector关心事件为OP_ACCEPT
        serverSocketChannel.register (selector, SelectionKey.OP_ACCEPT);
        //循环等待客户端连接
        while (true){
            if (selector.select (1000) == 0){
                System.out.println ("服务器等待了1s,无连接");
                continue;
            }
            //如果大于0就获取相关key的集合
            //如果返回>0,表示已经获取相关的事件
            //关注事件的集合
            //通过keys反向获取通道
            Set<SelectionKey> keys = selector.selectedKeys ();
            //便利keys,使用迭代器遍历
            Iterator<SelectionKey> keyIterator = keys.iterator ();
            while (keyIterator.hasNext ()){
                //获取到SelectionKey
                SelectionKey key = keyIterator.next ();
                //根据key对应的通道发生的事件做相应的处理
                if (key.isAcceptable ()){//OP_ACCEPT,有新的客户端连接我
                    //该客户端生成一个socketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept ();
                    //将socketChannel也注册到selector上,关注事件为OP_READ,同时给chanel关联一个buffer
                    socketChannel.register (selector,SelectionKey.OP_READ, ByteBuffer.allocate (1024));
                }
                if (key.isReadable ()){
                    //通过key反向获取对应channel
                    SocketChannel channel = (SocketChannel) key.channel ();
                    //获取对象关联的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment ();
                    channel.read (buffer);
                    System.out.println ("从客户端获取"+buffer.array ());
                }
                //手动从集合中移动当前的selectionKey,防止重复操作

            }

        }


    }
}
