//package com.leetcode.array;
//
//package cn.test;
//
//public class Test1 {
//
//    public static void main(String[] args) {
//
//    }
//
//    private int maxArea(int[] height) {
//        int max=0,res=0;
//        for(int i=0;i<height.length-1;i++){
//            for(int j=0;j<height.length;j++){
//                res=Math.min(height[i],height[j])*(j-i);
//                max=Math.max(max,res);
//            }
//        }
//        return max;
//    }
//
//    private int maxArea1(int[] height) {
//        int max = 0;
//        for (int i = 0, j = height.length - 1; i < j; ) {
//            int minHeight = height[i];
//            if (height[i] < height[j]) {
//                minHeight = height[i];
//                i++;
//            } else {
//                minHeight = height[j];
//                j--;
//            }
//            int area = (j - i + 1) * minHeight;
//            max = Math.max(max, area);
//        }
//
//        return max;
//    }
//}
//
//
//class Solution {
//    public int maxArea(int[] height) {
//        int max=0;
//        int res=0;
//        for(int i= 0,j=height.length-1;i<j;){
//            int minHeight=height[i];
//            if(height[i]<height[j]){
//                minHeight=height[i];
//                i++;
//            }else{
//                minHeight=height[j];
//                j--;
//            }
//            res=minHeight*(j-i);
//            max=Math.max(res,max);
//        }
//        return max;
//    }
//}