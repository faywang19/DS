package com.leetcode.array;

public class Q2RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4,4,6,7,7,7,8,8,8,9};
        int len = new Solution().removeDuplicates(nums);
        System.out.println(len);


    }
}


class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int len = nums.length;
        if (nums.length == 0 ) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        } else {
            for (index = 0; index < len - 1; index++) {
                for (int i = index+1; i < len - 2; i++) {
                    while (nums[i] == nums[index]) {
                        for (int j = i; j < len - 1; j++) {
                            nums[j] = nums[j + 1];
                        }
                        len--;
                    }
                }
                if (index == len - 3) {
                    while (nums[index] == nums[index+1]) {
                        nums[index+1] = nums[len +2];
                        len--;
                    }
                    if (nums[index] == nums[index+2]) {
                        len--;
                    }
                    index++;
                }
                if (nums[len - 1] == nums[index]&&(index!=len-1)) {
                    len--;
                }
            }
        }
        return len;
    }
}