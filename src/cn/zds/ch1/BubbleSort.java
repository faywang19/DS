package cn.zds.ch1;

public class BubbleSort {

    public static void BubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0--N-1
        //0--N-2
        //0--N-3
        // e-1  e
        for (int e = arr.length-1; e >0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    //交换arr的i和j值
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
