package com.leetcode.dp;

import java.util.Scanner;

public class Chorus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int cnt = scanner.nextInt();
            int[] height = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                height[i] = scanner.nextInt();
            }
            System.out.println(chorusFormation(cnt, height));
        }
        scanner.close();
    }


    public static int chorusFormation(int cnt, int[] height) {
        int[] left = new int[cnt];
        int[] right = new int[cnt];
        left[0] = right[cnt - 1] = 1;
        int res = 0;

        for (int i = 1; i < cnt; i++) {
            left[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] < height[i]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }


        for (int i = cnt - 2; i >=0; i--) {
            right[i] = 1;
            for (int j = i + 1; j < cnt; j++) {
                if (height[j] < height[i]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }

        for (int i = 0; i < cnt; i++) {
            if ((left[i] + right[i] - 1) > res) {
                res = left[i] + right[i] - 1;
            }
        }
        return cnt - res;
    }
}
