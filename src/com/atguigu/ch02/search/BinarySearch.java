package com.atguigu.ch02.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000,1234};
        /*System.out.println(binarySearch(arr, 0, arr.length - 1, 1000));
        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println("resIndexList="+resIndexList);*/
        System.out.println(binarySearch3(arr,19));
    }


    //二分查找，递归
    public static int binarySearch(int[] arr, int left, int right, int data) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (data > midVal) {
            return binarySearch(arr, mid + 1, right, data);
        } else if (data < midVal) {
            return binarySearch(arr, left, mid - 1, data);
        } else {
            return mid;
        }
    }

    /*思路分析：
    1、在找到mid索引值，不要马上返回
    2、向mid索引值的左边扫描，加入集合，右边扫描加入集合
    * */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int data) {

        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (data > midVal) {
            return binarySearch2(arr, mid + 1, right, data);
        } else if (data < midVal) {
            return binarySearch2(arr, left, mid - 1, data);
        } else {
            List<Integer> resIndexList = new ArrayList<>();
            //向mid索引值的左边扫描，将所有满足条件的下标放到集合中
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != data) {
                    break;
                }
                //否则，就temp放入到resIndexlist中
                resIndexList.add(temp);
                temp -= 1;//temp左移
            }
            resIndexList.add(mid);
            //向mid索引值的右边扫描，将所有满足条件的下标放到集合中
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != data) {
                    break;
                }
                resIndexList.add(temp);
                temp += 1;
            }
            return resIndexList;
        }
    }


    /**
     *
     * @param arr  带查找数组，升序
     * @param target   需要查找的数
     * @return  返回对应下标，-1没有找到
     */
    public static int binarySearch3(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;//需要向左边查找
            } else {
                left = mid + 1;//需要向右边查找
            }
        }
        return -1;
    }

}
