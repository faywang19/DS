package com.leetcode.linkedlist;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Q206reverselinkedlist {
    public static void main(String[] args) {

    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur=pre;
            pre = temp;
        }
        return cur;
    }
}
