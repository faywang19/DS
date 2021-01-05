package com.atguigu.ch01.recursion;

public class RecursionTest {

    public static void main(String[] args) {
        test(4);
    }

   /* public static void test(int n) {
        if (n > 2) {
            test(n-1);
        }
        System.out.println("n=" + n);
    }*/
//打印问题
     public static void test(int n) {
        if (n > 2) {
            test(n-1);
        }else {
            System.out.println("n=" + n);
        }
    }


    //阶乘问题
    public static int factorial(int n) {
        if (n == 1) {
            return n;
        }else {
            return factorial(n - 1) * n;
        }
    }
}
