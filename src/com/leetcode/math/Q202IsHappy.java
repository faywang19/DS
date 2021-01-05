package com.leetcode.math;

public class Q202IsHappy {

    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }

    public static boolean isHappy(int n) {
        String s = String.valueOf(n);
        while (Integer.parseInt(s) != 1) {
            try {
                s= String.valueOf(happy(Integer.parseInt(s)));
            } catch (Exception e) {
                return false;
            }
        }
        if (Integer.parseInt(s) == 1) {
            return true;
        }
        return false;
    }

    public static int happy(int n){
        String s = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum +=( s.charAt(i)-48)* ( s.charAt(i)-48);
        }
        return sum;
    }

   /* class Solution {
        public boolean isHappy(int n) {
*//*            Set<Integer> set = new HashSet<>();
            int m = 0;
            while(true){
                while(n != 0){
                    m += Math.pow(n%10, 2);
                    n /= 10;
                }
                if(m == 1){
                    return true;
                }
                if(set.contains(m)){
                    return false;
                }else{
                    set.add(m);
                    n = m;
                    m = 0;
                }
            }*//*
        }*/
}



