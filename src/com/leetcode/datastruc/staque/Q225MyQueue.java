package com.leetcode.datastruc.staque;

import java.util.LinkedList;
import java.util.Queue;

public class Q225MyQueue {

    public static void main(String[] args) {
        Q225MyQueue obj = new Q225MyQueue();
        obj.push(1);
        obj.push(2);
        int param_3 = obj.top();
        int param_2 = obj.pop();

        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    public Q225MyQueue() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int o = 0;
        while (queue1.size()>1) {
            queue2.add(queue1.poll());

        }
        if (queue1.size() == 1) {
             o = queue1.poll();
            while (queue2.size() > 0) {
                queue1.add(queue2.poll());
            }
        }
        return o;
    }

    /** Get the top element. */
    public int top() {
        int o = 0;
        while (queue1.size()>1) {
            queue2.add(queue1.poll());

        }
        if (queue1.size() == 1) {
            o = queue1.poll();
            queue2.add(o);
            while (queue2.size() > 0) {
                queue1.add(queue2.poll());
            }
        }
        return o;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.size()==0;
    }
}
/**
 * 一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。
 *
 * 这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。
 *
 * poll，remove 区别：
 *
 * remove() 和 poll() 方法都是从队列中删除第一个元素。
 * remove() 的行为与 Collection 接口的版本相似，
 * 但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。
 *
 * peek，element区别：
 *
 * element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null。
 */