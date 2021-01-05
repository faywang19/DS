package cn.test.juc.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return 1024;
    }

}

public class CallableDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //调用FutureTask实现联合Thread和Callable接口   FutrueTask继承了Runnable接口，并且能够以构造方法的方式
        //传入Callable接口
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask, "aaa").start();
        new Thread(futureTask, "bbb").start();
        //用FutureTask的get方法得到返回值
        Integer res = futureTask.get();
        System.out.println(res);
    }


}
