package com.atguigu.ch02.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);

    }

    //堆排序的方法
    public static void heapSort(int arr[]) {
        int temp = 0;
        /*System.out.println("堆排序");
        adjustHeap(arr,1,arr.length);
        System.out.println("第一次"+ Arrays.toString(arr));

        adjustHeap(arr,0,arr.length);
        System.out.println("第2次"+ Arrays.toString(arr));*/

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }
    //将一个数组，调整成一个大顶堆

    /**
     *功能：完成将以i对应的非叶子结点的树调整成大顶堆
     * @param arr 待调整的数组
     * @param i  非叶子结点在数组中的索引
     * @param length  表示对多少个元素继续调整，length在逐渐的减少
     */
    public static void adjustHeap(int arr[],int i,int length){
        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整
        //k=i*2+1  k是i结点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;//k指向右子节点
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];//把较大值赋给当前节点
                i = k;//i指向k，继续循环比较
            } else {
                break;
            }
        }
        //for循环结束后，已经将以i为父节点的树的最大值放在最顶上（局部）
        arr[i] = temp;//将temp值放到调整后的位置
    }
}
