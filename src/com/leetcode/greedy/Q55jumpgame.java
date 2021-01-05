package com.leetcode.greedy;

public class Q55jumpgame {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int endReachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= endReachable) {
                endReachable = i;
            }
        }
        return endReachable == 0;
        //只要记录能够跳到最后那个位置的的一个值最前者的值，
        //节省了数组记录最重要的循环，节省了一层循环
    }
}
