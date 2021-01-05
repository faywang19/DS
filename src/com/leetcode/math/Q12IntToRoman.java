package com.leetcode.math;

import java.util.Vector;

//整数转罗马数字
public class Q12IntToRoman {


    public static void main(String[] args) {
        System.out.println(intToRoman3(40));
    }
    public static String intToRoman(int num) {
        int k, h0, t0, g2;
        k=num/1000;
        //3999
        //999
        //
        h0=(num-k*1000)/100;
        t0=(num-k*1000-100*h0)/10;
        g2 = num % 10;
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = k; i > 0; i--) {
            stringBuilder.append('M');
        }
        while (h0 > 0) {
            if (h0 == 9) {
                stringBuilder.append("CM");
                h0 -= 9;
            }
            if (h0>=5&h0!=9){
                stringBuilder.append("D");
                h0 -= 5;
            } else if (h0 == 4) {
                stringBuilder.append("CD");
                h0 -= 4;
            } else if (h0 >= 1&&h0!= 4) {
                for (int i = h0; i > 0; i--) {
                    stringBuilder.append('C');
                    h0--;
                }
            }
        }
        while (t0 > 0) {
            if (t0 == 9) {
                stringBuilder.append("XC");
                t0 -= 9;
            }
            if (t0>=5&t0!=9){
                stringBuilder.append("L");
                t0 -= 5;
            }else if (t0 == 4) {
                stringBuilder.append("XL");
                t0 -= 4;
            }else if (t0 >= 1) {
                for (int i = t0; i > 0; i--) {
                    stringBuilder.append('X');
                    t0--;
                }
            }
        }
        while (g2 > 0) {
            if (g2 == 9) {
                stringBuilder.append("IX");
                g2 -= 9;
            }
            if (g2>=5&g2!=9){
                stringBuilder.append("V");
                g2 -= 5;
            }else if (g2 == 4) {
                stringBuilder.append("IV");
                g2 -= 4;
            }else if (g2 >= 1&&g2!= 4) {
                for (int i = g2; i > 0; i--) {
                    stringBuilder.append('I');
                    g2--;
                }
            }
        }
        return stringBuilder.toString();
    }


    public static String intToRoman2(int num) {
        if(num<1 || num >3999) return null;

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] key = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder str = new StringBuilder();
        for(int i=0;i<values.length;i++){
            while(num>=values[i]){
                num-=values[i];
                str.append(key[i]);
            }
        }
        return str.toString();
    }

    public static String intToRoman3(int num) {

        String[] thousand1 = new String[]{"", "M", "MM", "MMM"};
        String[] hundred1 = new String[] { "", "C", "CC", "CCC", "CD", "D","DC","DCC","DCCC","CM" };
        String[] decad1 = new String[]{ "", "X", "XX", "XXX", "XL", "L","LX","LXX","LXXX","XC" };
        String[] unit1 = new String[]{ "", "I", "II", "III", "IV", "V","VI","VII","VIII","IX" };
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(thousand1[num / 1000]);
        stringBuilder.append(hundred1[(num %1000)/100]);
        stringBuilder.append(decad1[(num %1000%100)/10]);
        stringBuilder.append(unit1[num % 1000%100%10]);
        return stringBuilder.toString();
    }
}








