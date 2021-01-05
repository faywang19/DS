package com.mashibing.synchronize;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class T00_CasAndUnsafe_Sync {
    private static int m = 0;

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        Object o = new Object();//设计一把锁
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(()->{
                synchronized (o) {//每次运行拿到这把锁才行
                    for (int j = 0; j < 10000; j++) {
                        m++;
                    }
                    latch.countDown();
                }
            });
        }

        Arrays.stream(threads).forEach((t) -> t.start());

        latch.await();
        System.out.println(m);
    }
}
