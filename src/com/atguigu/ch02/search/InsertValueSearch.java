package com.atguigu.ch02.search;

import java.util.Arrays;

public class InsertValueSearch {

    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i+1;
        }

//        System.out.println(Arrays.toString(arr));
        int index = insertValueSearch(arr, 0, arr.length - 1, 10);
        System.out.println("index="+index);

    }

    //编写插值查找算法
    public static int insertValueSearch(int[] arr, int left, int right, int value) {

        if (left > right|| value<arr[0]||value>arr[arr.length-1]) {
            return -1;
        }
        // value<arr[0]||value>arr[arr.length-1]必须要，防止越界
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];

        if (midVal < value) {
            return insertValueSearch(arr, mid + 1, right, value);
        } else if (midVal > value) {
            return insertValueSearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }
    }
}
