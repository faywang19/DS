package com.atguigu.ch05.fenzhi;

public class Hanoitower {

    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');

    }

    //使用分治算法
    public static void hanoiTower(int num, char a, char b, char c) {
        //如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //如果有n>=2，看做两个盘，最下边盘2，上面盘1
            //1、先把最上面的盘A->B,移动过程使用c
            hanoiTower(num - 1, a, c, b);
            //2、把最下面的盘A->C
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //3、把B的所有盘从B->C，移动过程使用a
            hanoiTower(num - 1, b, a, c);
        }
    }
}
