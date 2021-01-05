package com.leetcode.linkedlist;


class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}

public class Q24SwapNodesinPairs {
    public static void main(String[] args) {

    }

    private ListNode1 swapPairs(ListNode1 head) {
        //recursion
        //terminator
        if (head==null||head.next==null) return head;
        //process the current logic
        ListNode1 newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;

        //drill down

        //reverse the state


        return newHead;
    }
}
