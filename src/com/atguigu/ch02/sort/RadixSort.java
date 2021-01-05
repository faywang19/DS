package com.atguigu.ch02.sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }

    //基数排序方法
    public static void radixSort(int[] arr) {
        
        //基数排序代码：
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是位数
        int maxLength = (max + "").length();
        
        
        
        //定义一个二维数组，表示10个桶，每个桶就是 一个一维数组
        //二维数组包含10个一位数组,防止移出，每个一维数组大小定为arr.length
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        //使用循环
        for (int i = 0, n = 1; i < maxLength; i++,n*=10) {
            //针对每个元素对应位进行排序处理
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素个位的值
                int digitOfElement = arr[j]/n % 10;
                //放入对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按桶的顺序取出放入原来数组
            int index = 0;
            //遍历每一个桶
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，才放入原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶（即第k个一维数组）放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }

            System.out.println("第"+(i+1)+"轮，个位排序：" + Arrays.toString(arr));
        }








/*






        //第一轮（个位数）
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素个位的值
            int digitOfElement = arr[j] % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按桶的顺序取出放入原来数组
        int index = 0;
        //遍历每一个桶
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据，才放入原数组
            if (bucketElementCounts[k] != 0) {
                //循环该桶即第k个桶（即第k个一维数组）放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放到arr
                    arr[index++] = bucket[k][l];
                }
            }
            //第一轮处理后，需要将bucketElementCounts[k]=0
            bucketElementCounts[k] = 0;
        }

        System.out.println("第1轮，个位排序："+ Arrays.toString(arr));
        System.out.println("===========================================");
        //第二轮
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素个位的值
            int digitOfElement = arr[j] /10% 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按桶的顺序取出放入原来数组
        index = 0;
        //遍历每一个桶
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据，才放入原数组
            if (bucketElementCounts[k] != 0) {
                //循环该桶即第k个桶（即第k个一维数组）放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放到arr
                    arr[index++] = bucket[k][l];
                }
            }
        }

        System.out.println("第2轮，十位排序："+ Arrays.toString(arr));
        System.out.println("===========================================");
*/


    }
}
