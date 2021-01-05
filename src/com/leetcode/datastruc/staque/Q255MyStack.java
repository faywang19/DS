package com.leetcode.datastruc.staque;

import java.util.Stack;

public class Q255MyStack {
    Stack<Object> stack1=new Stack<Object>();
    Stack<Object> stack2=new Stack<Object>();

    public static void main(String[] args) {
        Q255MyStack q255MyStack = new Q255MyStack();
        q255MyStack.offer(1);
        q255MyStack.offer(2);
        q255MyStack.offer(3);
        boolean parm_1 = q255MyStack.isEmpty();
        Object parm_2 = q255MyStack.top();
        Object parm_3 = q255MyStack.poll();
        Object parm_4 = q255MyStack.poll();
        Object parm_5 = q255MyStack.top();
        boolean parm_6 = q255MyStack.isEmpty();
        Object parm_7 = q255MyStack.poll();
        Object parm_8 = q255MyStack.top();
        boolean parm_9 = q255MyStack.isEmpty();
        System.out.println(parm_1);
        System.out.println(parm_2);
        System.out.println(parm_3);
        System.out.println(parm_4);
        System.out.println(parm_5);
        System.out.println(parm_6);
        System.out.println(parm_7);
        System.out.println(parm_8);
        System.out.println(parm_9);
    }

    public Q255MyStack() {

    }

    public boolean isEmpty() {
        return stack1.size()==0;
    }


    public Object poll() {
        if (stack1.size() == 0) {
            return null;
        }
        if (stack1.size() == 1) {
            return stack1.pop();
        }
        while (stack1.size()>1) {
            stack2.push(stack1.pop());
        }
        Object pop = stack1.pop();
        while (stack2.size()>0) {
            stack1.push(stack2.pop());
        }
        return pop;
    }

    public Object top() {
        if (stack1.size() == 0) {
            return null;
        }
        if (stack1.size() == 1) {
            return stack1.peek();
        }
        while (stack1.size()>1) {
            stack2.push(stack1.pop());
        }
        Object pop = stack1.pop();
        stack2.push(pop);
        while (stack2.size()>0) {
            stack1.push(stack2.pop());
        }
        return pop;

    }


    public void offer(Object object) {
        stack1.push(object);
    }


}
