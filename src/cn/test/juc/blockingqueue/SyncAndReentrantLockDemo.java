package cn.test.juc.blockingqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResoucre{
    private int number=1;//A:1;B:2;C:3
    private Lock lock = new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();

    public void print5(){
        lock.lock();
        try{
            //1.判断
            while (number != 1) {
                condition1.await();
            }
            //2.干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + number + ":" + i);
            }
            number=2;
            condition2.signal();
            //3.唤醒
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try{
            //1.判断
            while (number != 2) {
                condition2.await();
            }
            //2.干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + number + ":" + i);
            }
            number=3;
            condition3.signal();
            //3.唤醒
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try{
            //1.判断
            while (number != 3) {
                condition3.await();
            }
            //2.干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + number + ":" + i);
            }
            number=1;
            condition1.signal();
            //3.唤醒
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

}
public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {
        ShareResoucre shareResoucre = new ShareResoucre();//线程操作资源类
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {//线程调用10次
                shareResoucre.print5();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                shareResoucre.print10();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                shareResoucre.print15();
            }
        },"C").start();
    }
}
