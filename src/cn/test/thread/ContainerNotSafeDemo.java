package cn.test.thread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i=1; i<=10; i++){
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }


    }

    public static void SetNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i=1; i<=30; i++){
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    public static void listNotSafe() {
        /*List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(System.out::println);*/

        //1.new Vector()
        //2.Collections.synchronizedList(new ArrayList<>())
        List<String> list = new CopyOnWriteArrayList<>();


        for (int i=1; i<=30; i++){
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
