package cn.netty.bio.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferTest {

    public static void main(String[] args) throws Exception {

        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");

        FileChannel channel = randomAccessFile.getChannel();


        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        map.put(0, (byte) 'H');
        map.put(3, (byte) '9');
        randomAccessFile.close();
        System.out.println("修改成功");

    }
}
