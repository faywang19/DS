package com.atguigu.ch02.search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr,1234));
    }

    //非递归方法得到一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //编写查找算法

    /**
     *
     * @param a 数组
     * @param key  需要查找的关键值
     * @return  返回的下标
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;//表示分隔数值的下标
        int mid = 0;//存放mid值
        int f[] = fib();//获取到数列
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]值可能大于a的长度，需要使用Arrays类，构造一个新的数组
        int[] temp = Arrays.copyOf(a, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        //使用while来循环处理，找到数key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;//即下次循环mid=f[k-1-1]-1
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;//即下次循环mid=f[k-1-2]-1
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;

    }
}
