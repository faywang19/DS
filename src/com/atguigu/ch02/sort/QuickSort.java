package com.atguigu.ch02.sort;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {-9, 78, 0, 23, -567, 70};
    }


    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(l + r) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }

            while (arr[r] > pivot) {
                r -= 1;
            }

            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换后，发现arr[l]==pivot值，r--前移
            if (arr[l] == pivot) {
                r -= 1;
            }

            if (arr[r] == pivot) {
                l -= 1;
            }
        }

        if (left < r) {
            quickSort(arr, left, r);
        }

        if (right > 1) {
            quickSort(arr, 1, right);
        }
    }

}


