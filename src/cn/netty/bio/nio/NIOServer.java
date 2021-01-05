package cn.netty.bio.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    public static void main(String[] args) throws Exception {

        //创建ServerSocketChannel->ServerSocket

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //得到一个Selector对象
        Selector selector = Selector.open();

        //绑定一个端口6666，在服务器端监听
        serverSocketChannel.bind(new InetSocketAddress(6666));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        //把serverSocketChannel注册到selector关心   事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System .out.println("客户端连接后，注册的SelectionKey的数量="+selector.keys().size());


        //循环等待客户端连接
        while (true) {

            //等待一秒，如果没有事件发生，返回
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }
            //如果返回的不是0，就获取到相关的selectionKey集合
            //如果返回的>0表示已经获取到关注的事件
            //selector.selectedKeys()返回关注事件的集合
            //通过selectionKeys反向获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            //遍历Set<SelectionKey>使用迭代器遍历
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()) {
                //获取到SelectionKey
                SelectionKey key = keyIterator.next();
                //根据key对应的通道发生的事件做响应相应处理
                if (key.isAcceptable()) {
                    //该客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功，生成了一个socketChannel" + serverSocketChannel);
                    //将SocketChannel设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //将socketChannel注册到selector，关注事件为OP_READ，同时给socketChannel关联一个buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System .out.println("客户端连接后，注册的SelectionKey的数量="+selector.keys().size());
                }
                if (key.isReadable()) {
                    //通过key反向获取到对应channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获取到该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("from 客户端" + new String(buffer.array()));
                }

                //手动从集合中移动当前的selectionKey，防止重复操作
                keyIterator.remove();
            }
        }
    }
}
