package cn.test.jvm.oom;

import java.util.ArrayList;
import java.util.List;

//java.lang.OutOfMemoryError: GC overhead limit exceeded
//-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
public class GCOverheadDemo {

    public static void main(String[] args) {

        int i = 0;

        List<String> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("*************"+i);
            e.printStackTrace();
            throw e;
        }

    }
}
