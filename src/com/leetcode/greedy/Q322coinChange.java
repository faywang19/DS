package com.leetcode.greedy;

public class Q322coinChange {

    public static void main(String[] args) {
//        int[] ints = {1, 2, 5};
        int[] ints = {1};
        int amount=11;
        System.out.println(new Q322coinChange().coinChange(ints,0));
    }
    private int coinChange(int[] coins, int amount) {
        int[] res=new int[coins.length];
        int ans = 0;
        for (int i = coins.length-1; i >=0; i--) {
            if (amount / coins[i] > 0) {
                res[i] = amount / coins[i];
                amount -= res[i]*coins[i];
            }
            if (amount < coins[0] &&amount != 0|| amount < 0) {
                return -1;
            }
            if (amount == 0) {
                return 0;
            }
        }
        for (int i = 0; i < res.length; i++) {
            ans+=res[i];
        }
        return ans;
    }
}
