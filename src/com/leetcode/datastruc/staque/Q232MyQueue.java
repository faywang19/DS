package com.leetcode.datastruc.staque;

import java.util.Date;
import java.util.Stack;

public class Q232MyQueue {


    public static void main(String[] args) {
        Date date1 = new Date();
        System.out.println(date1);

        Q232MyQueue obj = new Q232MyQueue();
         obj.push(1);
        obj.push(2);
         int param_1 = obj.peek();
         int param_2 = obj.pop();
         boolean param_3 = obj.empty();
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        Date date2 = new Date();
        System.out.println(date2);

    }

    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> stack2=new Stack<Integer>();

    public Q232MyQueue() {
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack1.size() == 1) {
            return stack1.pop();
        }
        while (stack1.size() >1) {
            stack2.push(stack1.pop());
        }
        int pop = stack1.pop();
        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        return pop;
    }

    public int peek() {
        if (stack1.size() == 1) {
            return stack1.peek();
        }
        while (stack1.size() >1) {
            stack2.push(stack1.pop());
        }
        int pop = stack1.pop();
        stack2.push(pop);
        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        return pop;
    }

    public boolean empty() {
        if (stack1.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
