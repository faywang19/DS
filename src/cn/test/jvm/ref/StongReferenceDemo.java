package cn.test.jvm.ref;

public class StongReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();//这样定义就是强引用
        Object obj2 = obj1;//obj2引用赋值
        obj1 = null;//置空
        System.gc();
        System.out.println(obj2);
    }
}
