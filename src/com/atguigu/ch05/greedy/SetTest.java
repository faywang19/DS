package com.atguigu.ch05.greedy;

import java.util.HashSet;

public class SetTest {

    public static void main(String[] args) {
        HashSet<String> hashSet1 = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();

        hashSet1.add("1");
        hashSet1.add("2");
        hashSet1.add("3");

        hashSet2.add("1");
        hashSet2.add("2");
        hashSet2.add("5");

        hashSet1.retainAll(hashSet2);
        System.out.println("hashSet1=" + hashSet1);
    }
}
