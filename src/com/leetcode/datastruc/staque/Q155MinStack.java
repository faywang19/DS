package com.leetcode.datastruc.staque;

import java.util.Stack;

public class Q155MinStack {

    public static void main(String[] args) {
        Q155MinStack stack = new Q155MinStack();
        stack.push(2147483646);
        stack.push(2147483646);
        stack.push(2147483647);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        stack.push(2147483647);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.push(-2147483648);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    int minElement = 0;

    public Q155MinStack() {
    }

    public void push(int x) {
        if (stack1.size()==0) {
            minElement=x;
            stack1.push(x);
            stack2.push(x);
        }else{
            if (x >= minElement) {
                stack1.push(x);
                stack2.push(minElement);
            } else {
                stack1.push(x);
                stack2.push(x);
                minElement=x;
            }
        }

    }

    public void pop() {
        stack1.pop();
        stack2.pop();
        if (!stack2.isEmpty()) {
            minElement = stack2.peek();
        } else {
            minElement = 0;
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
/**
 * import java.util.Stack;
 *
 * class MinStack {
 *
 *     private Stack<Integer> stackData;
 *     private Stack<Integer> stackMin;
 *
 *     /** initialize your data structure here.
 *public MinStack(){
        *this.stackData=new Stack<Integer>();
        *this.stackMin=new Stack<Integer>();
        *}
        *
        *public void push(int x){
        *if(this.stackMin.isEmpty()){
        *this.stackMin.push(x);
        *}else if(x<=this.getMin()){
        *this.stackMin.push(x);
        *}else{
        *int newMin=this.stackMin.peek();
        *this.stackMin.push(newMin);
        *}
        *this.stackData.push(x);
        *}
        *
        *public void pop(){
        *if(this.stackMin.isEmpty()){
        *throw new RuntimeException("Your stack is empty");
        *}
        *this.stackMin.pop();
        *this.stackData.pop();
        *}
        *
        *public int top(){
        *if(this.stackMin.isEmpty()){
        *throw new RuntimeException("Your stack is empty");
        *}
        *return this.stackData.peek();
        *
        *}
        *
        *public int getMin(){
        *if(this.stackMin.isEmpty()){
        *throw new RuntimeException("Your stack is empty");
        *}
        *return this.stackMin.pop();
        *}
        *}
 */