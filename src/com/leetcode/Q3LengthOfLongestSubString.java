package com.leetcode;

public class Q3LengthOfLongestSubString {
    public static void main(String[] args) {
        String s = "pwwkew";
        int i = new Solution().lengthOfLongestSubstring(s);
        System.out.println(i);

    }

}

class Solution {
    public  int lengthOfLongestSubstring(String s) {
        int[] m = new int[128];
        int len = 0;
        for(int i = 0, j = 0; j < s.length(); j++){
            i = Math.max(m[s.charAt(j)], i);
            len = Math.max(len, j - i + 1);
            m[s.charAt(j)] = j + 1;
        }
        return len;
    }
}