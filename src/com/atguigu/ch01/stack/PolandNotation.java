package com.atguigu.ch01.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {
        //先定义一个逆波兰表达式
        //（30+4）*5-6=》 3 4 + 5 * 6 -
        //4 * 5 -8 +60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +
        //数字和符号用空格隔开
//        String suffixExpression = "30 4 + 5 * 6 -";
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        //思路：
        //1、先将表达式放到ArrayList中
        //2、将ArrayList传递给一个方法，遍历ArrayList配合栈完成计算
        List<String> list = getListString(suffixExpression);
        System.out.println("list="+list);
        int res = calculate(list);
        System.out.println("计算的结果是="+res);

    }

    //将一个逆波兰表达式，依次将数据和运算符放入ArrayList中,好取数，不然设置index太麻烦
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分隔
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    /*
    完成对逆波兰表达式的运算
    1）从左至右扫描，将3和4压入堆栈
    2）遇到+运算符，因此弹出4和3，计算相加，得7压入
    3）5入栈
    4）*运算符，弹出计算35入栈
    5）6入栈
    6）最后-运算，35-6，次顶-顶元素，得到最终结果
     */

    public static int calculate(List<String> ls) {
        //创建栈只需一个
        Stack<String> stack = new Stack<>();
        //遍历ls
        for (String item : ls) {
            //这里使用正则表达式取出数
            if (item.matches("\\d+")) {//匹配的是多位数
                //入栈
                stack.push(item);
            }else{
                //pop出两个数，并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                //把res压入栈
                stack.push("" + res);//整数转字符串，+"" 空引号
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}
