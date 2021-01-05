package com.leetcode.math;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *
 */
public class Q27Divide {
    public static void main(String[] args) {
        System.out.println(divide1(-2147483648,-2));
    }


    public static int divide(int dividend, int divisor) {
        int dd = Math.abs(dividend);
        if (dividend == Integer.MIN_VALUE) {
            dd = Integer.MAX_VALUE + 1;}
        int dr = Math.abs(divisor);
        int i = 0;
        while (dd >= dr) {
            dd -= dr;
            i += 1;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            i = Integer.MIN_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            i = Integer.MAX_VALUE;
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            i = -i;
        }
        return i ;
    }

    public static int divide1(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if(dividend>0) {
            dividend = -dividend;
        }
        if(divisor>0) divisor = -divisor;
        while(dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = - result;
        }
        return result;
    }
}
