package cn.zds.ch1;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //  0--n-1
        //  1--n-1
        //  2--n-1
        for (int i = 0; i < arr.length - 1; i++) {
            //最小值在哪个位置上  i~N-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {//i~n-1找最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
