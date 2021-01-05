package cn.test.jvm.oom;

import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class DirectBufferMemoryDemo {

    public static void main(String[] args) {

        //配置的maxDirectMemory：1580.5MB
        System.out.println("配置的maxDirectMemory：" + (sun.misc.VM.maxDirectMemory() / (double) 1024 / 1024) + "MB");
        try{
            Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace();}
        //-XX:MaxDirectMemorySize=5m  配置为5MB，实际使用6MB，故意使坏
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);//最好提前检查本地直接内存扛不扛得住
    }
}
