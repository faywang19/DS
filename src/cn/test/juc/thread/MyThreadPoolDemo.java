/*
package cn.test.juc.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 第四种获得试用java多线程的方式，线程池
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        //模拟10个用户来处理业务，每个用户就是一个来自外部的请求线程

        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个处理线程

        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }


    }
}
*/
