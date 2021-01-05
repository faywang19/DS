package cn.netty.bio.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOChannel02 {

    public static void main(String[] args) throws Exception {

        File file = new File("d:\\file01.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());

        channel.read(byteBuffer);

//        byteBuffer.flip();不用反转

//        byte b = byteBuffer.get();不用缓冲区get

        System.out.println(new String(byteBuffer.array()));

        fileInputStream.close();

    }
}
