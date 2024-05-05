package com.msb.basic;

import com.lintcode.common.DoubleNode;
import com.lintcode.common.ListNode;

public class LinkedListOperation {

    public ListNode reverseLinkedList(ListNode node) {
        ListNode pre = null;
        ListNode head = node;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public DoubleNode reverseDoubleLinkedList(DoubleNode node) {
        DoubleNode pre = null;
        DoubleNode head = node;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
