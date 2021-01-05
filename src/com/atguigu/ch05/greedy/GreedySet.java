package com.atguigu.ch05.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedySet {

    public static void main(String[] args) {
        //创建广播电台，放入到Map
        HashMap<String, HashSet<String>> broardcasts = new HashMap<>();
        //将各个电台放到broadcasts
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("天津");
        hashSet1.add("上海");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("北京");
        hashSet2.add("广州");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map
        broardcasts.put("K1", hashSet1);
        broardcasts.put("K2", hashSet2);
        broardcasts.put("K3", hashSet3);
        broardcasts.put("K4", hashSet4);
        broardcasts.put("K5", hashSet5);

        //allAreas存放所有的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建ArrayList，存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时的集合，在遍历的过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<Object> tempSet = new HashSet<>();

        //定义给maxKey，保存在一次遍历过程中，能够覆盖最大未覆盖地区的key
        //如果maxKey不为null，则会加入到selects
        String maxKey = null;

        while (allAreas.size() != 0) {
            //遍历broadcasts,取出对应key
            maxKey = null;
            for (String key : broardcasts.keySet()) {
                //每进行一次for
                tempSet.clear();
                //每次进行一次while需要
                //当前这个key能够覆盖的地区
                HashSet<String> areas = broardcasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet和allAreas集合的交集，交集会赋给tempSet
                tempSet.retainAll(allAreas);

                //如果当前这个集合包含的未覆盖地区的数量，比maxKey指向的集合地区还多
                //就需要重置maxKey
                //tempSet.size() > broardcasts.get(maxKey).size())
                if (tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > broardcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            //maxKey!=null,就应该将maxKey加入到selects中
            if (maxKey != null) {
                selects.add(maxKey);
                //将maxKey指向的广播覆盖的地区，从allAreas去掉
                allAreas.removeAll(broardcasts.get(maxKey));
            }
        }
        System.out.println("得到的选择结果："+selects);
    }
}
