package cn.netty.bio.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOChannel01 {

    public static void main(String[] args) throws Exception {

        //控制台到地址的信息
        String s1 = "hello world";

        //文件输出流，确定位置和文件
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\file01.txt");

        //在文件输出流中建立通道，利用通道去实现写入
        FileChannel channel = fileOutputStream.getChannel();

        //建立一定量的缓存，这里使用的是字节缓存，分配1024
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //先把信息放进缓存中，保证以缓存的形式放入，用put方法即可
        byteBuffer.put(s1.getBytes());

        //缓存写完之后，反转换姿势
        byteBuffer.flip();

        //利用通道将缓存的信息读入
        channel.write(byteBuffer);

        //关闭通道
        channel.close();
    }
}
