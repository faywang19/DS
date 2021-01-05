package com.leetcode.math;

import java.lang.String;

import java.util.HashMap;

/**
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 */
public class Q13RomanToInt {


    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt2("IV"));
    }

    public static int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("M", 1000);

        int num = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                num += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                num += map.get(s.substring(i, i + 1));
                i += 1;
            }
        }
        return num;
    }


    public static int romanToInt2(String s) {

        char[] chars = s.toCharArray();
        int len = chars.length, ans = 0;
        for (int i = 0; i < len; i++) {
            switch (chars[i]) {
                case 'I':
                    if (i + 1 < len && (chars[i + 1] == 'X' || chars[i + 1] == 'V')) {
                        ans -= 1;
                    } else {
                        ans += 1;
                    }
                    break;
                case 'X':
                    if (i + 1 < len && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                        ans -= 10;
                    } else {
                        ans += 10;
                    }
                    break;
                case 'C':
                    if (i + 1 < len && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                        ans -= 100;
                    } else {
                        ans += 100;
                    }
                    break;
                case 'V':
                    ans += 5;
                    break;
                case 'L':
                    ans += 50;
                    break;
                case 'D':
                    ans += 500;
                    break;
                case 'M':
                    ans += 1000;
                    break;
            }
        }
        return ans;
    }
}





