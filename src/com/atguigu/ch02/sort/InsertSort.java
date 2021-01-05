package com.atguigu.ch02.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

    public static void main(String[] args) {

//        int arr[] = {101, 34, 119, 1};
        int[] arr = new int[80000];
        for (int i = 0; i <80000; i++) {
            arr[i] = (int)(Math.random() * 80000);//[0, 80000)
        }

        System.out.println("排序前");
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date1);
        System.out.println("排序前的时间="+format);

        insertSort(arr);
        System.out.println("排序后");

        Date date2= new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format2 = simpleDateFormat2.format(date2);
        System.out.println("排序前的时间="+format2);





    }

    //插入排序
    public static void insertSort(int[] arr) {

        int insertVal = 0;
        int insertIndex = 0;
        //使用for循环进行代码简化
        for (int i = 1; i <arr.length ; i++) {

            insertVal = arr[i];
            insertIndex = i - 1;//即arr[1]的前面这个数的下标
            //给insertVal找到插入的位置
            //1、insertIndex》=0  保证在给insertVal找插入位置，不越界
            //2、insertVal < arr[insertIndex]待插入的数，还没有找到插入位置
            //3、就需要将arr[indexIndex]后移

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];//arr[insertIndex]
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到，insertIndex+1
            //考虑是否需要赋值
            if (insertIndex+1==i) {
                arr[insertIndex + 1] = insertVal;
            }
         /*   System.out.println("第" + i + "轮插入");
            System.out.println(Arrays.toString(arr));*/

        }

















        /*
        //第一轮  {34,101,119,1}
        //定义待插入的数
        int insertVal = arr[1];
        int insertIndex = 1 - 1;//即arr[1]的前面这个数的下标
        //给insertVal找到插入的位置
        //1、insertIndex》=0  保证在给insertVal找插入位置，不越界
        //2、insertVal < arr[insertIndex]待插入的数，还没有找到插入位置
        //3、就需要将arr[indexIndex]后移

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];//arr[insertIndex]
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到，insertIndex+1
        arr[insertIndex + 1] = insertVal;

        System.out.println("第一轮插入");
        System.out.println(Arrays.toString(arr));

        //第二轮插入
        insertVal = arr[2];
        insertIndex = 2 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];//arr[insertIndex]
            insertIndex--;
        }

        arr[insertIndex + 1] = insertVal;

        System.out.println("第2轮插入");
        System.out.println(Arrays.toString(arr));


        //第3轮插入
        insertVal = arr[3];
        insertIndex = 3 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];//arr[insertIndex]
            insertIndex--;
        }

        arr[insertIndex + 1] = insertVal;

        System.out.println("第3轮插入");
        System.out.println(Arrays.toString(arr));
        */




    }

}
