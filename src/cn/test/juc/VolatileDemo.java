package cn.test.juc;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData {
    volatile int number=0;
    //volatile int number=0;

    public void addTo60() {
        this.number = 60;
    }

    public void addPlusPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addMyAtomic() {
        atomicInteger.getAndIncrement();
    }
}


/**
 * 1.1验证volatile的可见性
 * 假定int number=0；number变量之前根本没有添加volatile关键字修饰，没有可见性
 */
public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();//最终一致性能不能保证-->原子性
                    myData.addMyAtomic();
                }
            }, String.valueOf(i)).start();
        }

        //等待上面20个线程都全部计算完成后，再用main线程取得最终的结果是多少？
        while (Thread.activeCount() > 2) {//默认后台main+GC线程
            Thread.yield();//yied退出  我不执行，下不来
        }
        System.out.println(Thread.currentThread().getName() + "\t int type, final number value:" + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger type, final number value:" + myData.atomicInteger);

    }


    public static void seeByOk() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            //暂停一会线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number value" + myData.number);

        },"AAA").start();

        //第二个线程是main线程
        while (myData.number == 0) {
            //main线程就一直在这里等待循环，知道number值不再等于0
        }

        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }
}
