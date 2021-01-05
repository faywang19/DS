package com.leetcode.math;



public class Q9IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome1(111));
    }

    ///简单粗暴，看看就行,只需要比较一半
    public static boolean isPalindrome1(int x){
        String s = new StringBuilder(x + "").reverse().toString();
        return ((x + "") .equals (s));
    }

    //边反转边比较，只需要比较一半即可
    public static boolean isPalindrome2(int x){
        if (x<0||x%10==0&x!=0)
            return false;
        int num = x;
        int rev = 0;
        while (rev<num) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return (x == rev || x == rev / 10);
    }
}


