package com.atguigu.ch00;

public class StringTest {
    public static void main(String[] args) {
        String str = "java,java,hello world!";
        String newStr = str.replaceAll("java", "shanguigu");
        System.out.println("newStr="+newStr);
    }
}
