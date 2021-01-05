package cn.netty.bio.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Scattering  将数据写入到buffer时，可采用buffer数组，依次写入
 * Gathering   从buffer读取数据，采取buffer数组，依次读
 */
public class ScatteringandGatheringTest {

    public static void main(String[] args) throws Exception {

        //使用ServerSocketChannel和SocketChannel网络

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        //绑定端口到socket，并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        //创建buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        //等客户端连接telnet
        SocketChannel socketChannel = serverSocketChannel.accept();
        int messageLength = 8;//假定从客户端接收8个字节
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                long l = socketChannel.read(byteBuffers);
                byteRead += 1;//累计读取的字节数
                System.out.println("byteRead=" + byteRead);
                //使用流打印，看看当时的这个buffer的position和limit
                Arrays.asList(byteBuffers).stream().map(buffer -> "position=" +
                        buffer.position() + ",limit=" + buffer.limit()).forEach(System.out::println);
            }

            //将所有的buffer进行flip
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());

            //将数据读出显示到客户端
            long byteWrite = 0;
            while (byteWrite < messageLength) {
                long l = socketChannel.write(byteBuffers);
                byteWrite += 1;
            }

            //将多有的buffer进行clear
            Arrays.asList(byteBuffers).forEach(buffer->{
                buffer.clear();});

            System.out.println("byteRead:=" + byteRead + "byteWrite:=" + byteWrite + ",messagelength" + messageLength);
        }
    }

}
