package com.msb.basic;

import com.lintcode.common.ListNode;

public class LinkedList_MyStack {
    private ListNode head;
    private int size;

    public LinkedList_MyStack(){
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void push(int val) {
        ListNode cur = new ListNode(val);
        if (head == null) {
            head = cur;
        } else {
            cur.next = head;
            head = cur;
        }
        size++;
    }

    public int pop() {
        int value = -1;
        if (head != null) {
            value = head.val;
            head = head.next;
        }
        size--;
        return value;
    }

    public int peek() {
        int value = -1;
        if (head != null) {
            value = head.val;
        }
        return value;
    }
    
}
