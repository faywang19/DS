package com.reverse.primary;

public class Apple {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.eatApple().eatApple();
    }

    int i = 0;

    Apple eatApple() {
        i++;
        System.out.println(i);
        return this;
    }
}
