package com.atguigu.ch02.sort;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.SimpleTimeZone;

public class BubbleSort {

    public static void main(String[] args) {
         //测试冒泡排序
     /*   int arr[] = {3, 9, -1, 10, 20};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));*/

        //80000随机数测试
        int[] arr = new int[80000];
        for (int i = 0; i <80000; i++) {
            arr[i] = (int)(Math.random() * 80000);//[0, 80000)
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date1);
        System.out.println("排序前的时间="+format);




        bubbleSort(arr);

        Date date2= new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format2 = simpleDateFormat2.format(date2);
        System.out.println("排序前的时间="+format2);

        /*System.out.println("排序后");
        System.out.println(Arrays.toString(arr));*/

    }

       /* //第二趟排序，就是将最大的数排到倒数第二位
        for (int i = 0; i < arr.length - 1 - 1; i++) {
            //如果前面的数比后面的数大，则交换
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));*/


    public static void bubbleSort(int[] arr) {

        boolean flag = false;//标识变量，标识是否进行交换
        //冒泡排序，就是将最大的数排到最后O(n^2)
        int temp = 0;//临时变量
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1-i; j++) {
                //如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
/*            System.out.println("第"+(i+1)+"趟排序后的数组");
            System.out.println(Arrays.toString(arr));*/

            if (!flag) {//在一趟排序中，一次交换都没有发生
                break;
            }else {
                flag = false;//重置falg，进行下次判断
            }
        }
    }
}
