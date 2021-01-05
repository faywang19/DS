package com.atguigu.ch01.stack;


public class Calculator {

    public static void main(String[] args) {
        String expression = "36+2*6-2";
        //创建两个栈，数栈，符号栈
        ArrayStack2 numstack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描到的char保存到ch
        String keepNum = "";//用于拼接  多位数
        //开始while循环的扫描expression
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做响应的处理
            if (operStack.isOper(ch)) {//如果是运算符
                //判断当前的符号是否为空
                if (!operStack.isEmpty()) {
                    //处理，优先级小
                    if (operStack.prioriy(ch) <= operStack.prioriy(operStack.peek())) {
                        num1 = numstack.pop();
                        num2 = numstack.pop();
                        oper = operStack.pop();
                        res = numstack.cal(num1, num2, oper);
                        //把运算的结果入数栈
                        numstack.push(res);
                        //然后将当前的操作符入符号栈
                        operStack.push(ch);
                    }else{
                        //优先级大
                        operStack.push(ch);
                    }
                }else{
                    //如果为空直接入栈
                    operStack.push(ch);//1+3
                }
            }else{
                //如果是数，则直接入栈
//                numstack.push(ch - 48);//ASCII码
                //分析思路：
                /*
                1、当处理多位数时，不能发现是一个数就立即入栈，因为可能是多位数
                2、在处理数，需要向expression的表达式的index后再看一位，如果是数就进行扫描，如果是符号才入栈
                3、需要定义一个变量  字符串  用于拼接*/

                //处理多位数
                keepNum += ch;


                //如果ch已经是expression的最后一位，就直接入栈
                if (index==expression.length()-1) {
                    numstack.push(Integer.parseInt(keepNum));
                }else {
                    //判断下一个字符是不是数字，如果是数字继续扫描，否则是运算符，则入栈
                    //注意只是看一位，不是index++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则如转keepNum是1或123
                        numstack.push(Integer.parseInt(keepNum));
                        //重要的！
                        keepNum = "";
                    }
                }
            }
            //让index+1，并判断是否扫描到最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //当表达式扫描完毕，就顺序的从数栈和符号栈中pop处响应的数据并运行
        while (true) {
            //如果符号栈为空，则计算到最后的结果，数栈中只有一个数字(结果)
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numstack.pop();
            num2 = numstack.pop();
            oper = operStack.pop();
            res = numstack.cal(num1, num2, oper);
            numstack.push(res);
        }
        //将数栈的最后树pop出来
        int res2 = numstack.pop();
        System.out.printf("表达式%s=%d",expression,res2);
    }
}
//定义一个ArrayStack2表示栈
class ArrayStack2 {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈
    private int top = -1;

    //构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //返回栈顶第一个元素
    public int peek() {
        return stack[top];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈push
    public void push(int value) {
        //先判断是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈pop 将栈顶的数据返回
    public int pop() {
        //先判断是否为空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况(遍历栈)，需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据！！");
            return;
        }
        //需要从栈顶开始显示数据
        for (int i =top; i >=0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    //返回运算符的优先级，优先级是程序员确定，优先级使用数字表示
    //数字越大，优先级越高
    public int prioriy(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }


    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch(oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}


