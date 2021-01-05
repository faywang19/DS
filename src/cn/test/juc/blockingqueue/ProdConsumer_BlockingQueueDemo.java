package cn.test.juc.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MySource{
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();//需要new对象
    BlockingQueue<String> blockingQueue = null;

    public MySource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void MyProd() throws Exception{
        String data = null;
        boolean retValue;
        while (flag) {
            data=atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列"+data+"成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t Main线程叫停，表示Flag=false，生产动作结束");
    }


    public void MyConsumer() throws  Exception {
        String result = null;
        boolean retValue;
        while (flag) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过2秒钟没有取出数据，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + result + "成功");
        }
    }

    public void Stop() throws Exception {
        this.flag = false;
    }
}


public class ProdConsumer_BlockingQueueDemo {

    public static void main(String[] args) throws Exception {
        MySource mySource = new MySource(new ArrayBlockingQueue(50));
        System.out.println();
        System.out.println();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try {
                mySource.MyProd();
                System.out.println();
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            try {
                mySource.MyConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        try{TimeUnit.SECONDS.sleep( 26 ) ; } catch (InterruptedException e) { e.printStackTrace();}

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("5s时间到，main线程叫停，活动结束");

        mySource.Stop();
    }
}
