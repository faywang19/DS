package com.reverse.primary;

public class Person {

    public String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String showInfo() {
        return "name="+name+",age="+age;
    }
}
