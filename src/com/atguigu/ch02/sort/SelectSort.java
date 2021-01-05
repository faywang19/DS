package com.atguigu.ch02.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

    public static void main(String[] args) {
//        int arr[] = {101, 34, 119, 1,-1,90,123};

        //80000随机数测试
        int[] arr = new int[80000];
        for (int i = 0; i <80000; i++) {
            arr[i] = (int)(Math.random() * 80000);//[0, 80000)
        }

        System.out.println("排序前");
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date1);
        System.out.println("排序前的时间="+format);

        selectSort(arr);
        System.out.println("排序后");

        Date date2= new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format2 = simpleDateFormat2.format(date2);
        System.out.println("排序前的时间="+format2);
//        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void selectSort(int[] arr) {

     for (int i = 0; i < arr.length - 1; i++) {

        //第一轮
        int minIndex = i;
        int min = arr[i];
        for (int j = i+1; j <arr.length ; j++) {
            if (min > arr[j]) {
                min = arr[j];//重置min
                minIndex = j;//重置minIndex
            }
        }

        //将最小值，放在arr[0]，即交换
        if (minIndex != i) {
            arr[minIndex] = arr[i];
            arr[i] = min;
        }


        /*System.out.println("第"+(i+1)+"轮后！！");
        System.out.println(Arrays.toString(arr));*/
     }














        /*//使用逐步推导的方式 原始 101,34,119,1
        //第一轮： 1,34,119,101
        //算法先简单再复杂，把复杂的算法拆分成简单的问题，逐步解决

        //第一轮
        int minIndex = 0;
        int min = arr[0];
        for (int j = 0+1; j <arr.length ; j++) {
            if (min > arr[j]) {
                min = arr[j];//重置min
                minIndex = j;//重置minIndex
            }
        }

        //将最小值，放在arr[0]，即交换
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }


        System.out.println("第1轮后！！");
        System.out.println(Arrays.toString(arr));

        //第2轮
        minIndex = 1;
        min = arr[1];
        for (int j = 1+1; j <arr.length ; j++) {
            if (min > arr[j]) {
                min = arr[j];//重置min
                minIndex = j;//重置minIndex
            }
        }

        //将最小值，放在arr[1]，即交换
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }

        System.out.println("第2轮后！！");
        System.out.println(Arrays.toString(arr));

        //第3轮
        minIndex = 2;
        min = arr[2];
        for (int j = 2+1; j <arr.length ; j++) {
            if (min > arr[j]) {
                min = arr[j];//重置min
                minIndex = j;//重置minIndex
            }
        }

        //将最小值，放在arr[1]，即交换
        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }

        System.out.println("第3轮后！！");
        System.out.println(Arrays.toString(arr));*/
    }
}
