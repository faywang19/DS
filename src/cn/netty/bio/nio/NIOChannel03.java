package cn.netty.bio.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOChannel03 {

    public static void main(String[] args) throws Exception {

        File file1 = new File("d:\\file01.txt");

        FileInputStream fileInputStream = new FileInputStream(file1);

        FileChannel channel1 = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file1.length());

        channel1.read(byteBuffer);

        byteBuffer.flip();

        FileOutputStream fileOutputStream = new FileOutputStream("d:\\file02.txt");

        FileChannel channel2 = fileOutputStream.getChannel();

        channel2.read(byteBuffer);

        fileInputStream.close();
        fileOutputStream.close();
    }
}
