package com.leetcode.dp;

import java.util.*;

public class ClimberStairs {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isAnagram("anagram", "nagnrnm"));
    }

}



class Solution1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length()-1; i++) {
            map.put(s.substring(i, i + 1), i);
        }
        for (int i = 0; i < t.length()-1; i++) {
            while (map.containsKey(t.substring(i, i + 1))) {

            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = s.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);//善用Arrays集合类
    }
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']++;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;//善用Arrays集合类
    }


}

class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<Integer> list=new ArrayList<>();
            List<List<Integer>> listRes=new ArrayList<>();
            for(int i=0;i<nums.length-2;i++){
                for(int j=i+1;j<nums.length-1;j++){
                    for(int k=i+2;k<nums.length;k++){
                        if(nums[i]+nums[j]==nums[k]*(-1)){
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            listRes.add(list);
                        }
                    }
                }
            }
            return listRes;
        }
}