package com.leetcode.dp;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] arr = new int[n];
            int[] left = new int[n];
            int[] right = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = in.nextInt();
            }
            //动态规划
            //求最长递增子序列
            for(int i=0;i<n;i++){
                left[i] = 1;
                for(int j=i-1;j>=0;j--)
                    if(arr[j]<arr[i])
                        left[i] = Math.max(left[i], left[j]+1);
            }

            //求从右边数起的最长递减子序列
            for(int i=n-1;i>=0;i--){
                right[i] = 1;
                for(int j=i+1;j<n;j++)
                    if(arr[i]>arr[j])
                        right[i] = Math.max(right[i], right[j]+1);
            }
            int max=0;
            for(int i=0;i<n;i++){
                max = Math.max(max, left[i]+right[i]-1);
            }
            System.out.println(n-max);
        }
    }
}

