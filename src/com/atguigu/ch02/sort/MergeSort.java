package com.atguigu.ch02.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
        int temp[] = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));


    }

    //归并排序
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归
            mergeSort(arr, left, mid, temp);
            //向右递归
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }








    /**
     *
     * @param arr  排序的原始数组
     * @param left   左边索引
     * @param mid    中间索引
     * @param right   右边索引
     * @param temp  中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right,int []temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;//指向temp数组的当前索引

        //1、先把左右两边有序的数组按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //2、把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //3、将temp数组的元素拷贝到arr
//并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }


    }
}
