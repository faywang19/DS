package com.reverse.primary;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {

    public static void main(String[] args) {
        Class student = null;
        try {
            student = Class.forName("com.reverse.primary.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //获取对象的所有公共属性
        Field[] fields = student.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println("================");

        //获取对象所有属性，但不包含继承的
        Field[] dfs = student.getDeclaredFields();
        for (Field df : dfs) {
            System.out.println(df);
        }
        System.out.println("================");

        //获取对象所有的公共构造方法
        Constructor[] constructors = student.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println("================");
        //获取对象所有的构造方法
        Constructor[] declaredConstructors = student.getDeclaredConstructors();
        for (Constructor dc : declaredConstructors) {
            System.out.println(dc);
        }

        //获取对象的所有公共方法
        Method[] methods = student.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("================");

        Method[] declaredMethods = student.getDeclaredMethods();
        for (Method dm : declaredMethods) {
            System.out.println(dm);
        }
        System.out.println("================");
        try {
            Class c = Class.forName("com.reverse.primary.Student");
            Student stu1 = (Student)c.newInstance();
            stu1.setAddress("天津");
            System.out.println(stu1);


            Constructor<Student> constructor = c.getConstructor(String.class, int.class, String.class, String.class);
            Student student1 = constructor.newInstance("os", 24, "la", "天津");
            System.out.println(student1);

            Method showInfo = c.getMethod("showInfo");
            Object invoke = showInfo.invoke(student1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
