package com.atguigu.ch02.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

    public static void main(String[] args) {
        /*int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);*/

        int[] arr = new int[80000];
        for (int i = 0; i <80000; i++) {
            arr[i] = (int)(Math.random() * 80000);//[0, 80000)
        }

        System.out.println("移位排序前");
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date1);
        System.out.println("移位排序前的时间="+format);

        shellSort2(arr);
        System.out.println("排序后");

        Date date2= new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format2 = simpleDateFormat2.format(date2);
        System.out.println("移位排序后的时间="+format2);
    }

    //使用逐步推导的方式编写
    /*public static void shellSort(int[] arr) {
        int count = 0;
        int temp = 0;
        //根据逐步分析，使用循环处理
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有元素(共gap组，每组个元素)，步长为gap
                for (int j = i-gap; j >=0; j-=gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }

//            System.out.println("希尔排序第"+(++count)+"轮后="+ Arrays.toString(arr));
        }

    }*/










        /*int temp = 0;
        //希尔排序是第1轮排序
        //因为第一轮排序，是将10个数据分成了5组
        for (int i = 5; i < arr.length; i++) {
            //遍历各组中所有元素(共5组，每组2个元素)，步长为5
            for (int j = i-5; j >=0; j-=5) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }

        System.out.println("希尔排序第1轮后="+ Arrays.toString(arr));

        //第二轮
        //因为第2轮排序，是将10个数据分成了5/2=2组
        for (int i = 2; i < arr.length; i++) {
            //遍历各组中所有元素(共5组，每组2个元素)，步长为5
            for (int j = i-2; j >=0; j-=2) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }

        System.out.println("希尔排序第2轮后="+ Arrays.toString(arr));

        //第3轮
        //因为第3轮排序，是将10个数据分成了2/2=1组
        for (int i = 1; i < arr.length; i++) {
            //遍历各组中所有元素(共5组，每组2个元素)，步长为5
            for (int j = i-1; j >=0; j-=1) {
                //如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("希尔排序第3轮后="+ Arrays.toString(arr));
*/


        //对交换式的希尔排序进行优化->移位

    public static void shellSort2(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
          //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while循环后，给temp找到插入的位置
                    arr[j] = temp;
                }
            }
        }

    }




}