package com.leetcode.binarySearch;

public class Q367ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(new Q367ValidPerfectSquare().isPerfectSquare(681));
        System.out.println(Math.sqrt(808201));

        System.out.println(Integer.MAX_VALUE);
    }


    public boolean isPerfectSquare(int num) {
        if (num <= 0) return false;
        int left = 1;
        int right = num;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if( mid< num/mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right * right == num;
    }
}