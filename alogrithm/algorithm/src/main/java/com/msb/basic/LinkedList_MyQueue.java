package com.msb.basic;

import com.lintcode.common.ListNode;

public class LinkedList_MyQueue {
    private ListNode head;
    private ListNode tail;
    private int size = 0;

    public LinkedList_MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void offer(int val) {
        ListNode cur = new ListNode(val);
        if (tail == null) {
            head = cur;
            tail = cur;
        } else {
            tail.next = cur;
            tail = cur;
        }
        size++;
    }

    public int poll() {
        int value = -1;
        if (head != null) {
            value = head.val;
            head = head.next;
            size--;
        } else {
            tail = null;
        }
        return value;
    }

    public int peek(){
        int value = -1;
        if (head != null) {
            value = head.val;
        }
        return value;
    }

}
