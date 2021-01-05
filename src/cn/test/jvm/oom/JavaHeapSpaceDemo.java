package cn.test.jvm.oom;

import java.util.Random;

public class JavaHeapSpaceDemo {
    public static void main(String[] args) {

        /*String str = "atguigu";
        while (true) {
            str += str + new Random().nextInt(1111111111) + new Random().nextInt(222222222);
            str.intern();
        }*/

        byte[] bytes = new byte[80*1024*1024];
    }
}
