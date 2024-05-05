package com.msb.basic;

import com.lintcode.common.ListNode;

public class LinkedList_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        ListNode l = len1 > len2? head1 : head2;
        ListNode s = len1 > len2? head2 : head1;
        ListNode curL = l;
        ListNode curS = s;
        ListNode last = curL;
        int carry = 0;
        int curNum = 0;
        while (curS != null) {
            curNum = curS.val + curL.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            curL = curL.next;
            curS = curS.next;
            last = curL;
        }

        while (curL != null) {
            curNum = curL.val + carry;
            curL.val = (curNum %10);
            carry = curNum / 10;
            last = curL;            
            curL = curL.next;
        }

        if (carry != 0){
            ListNode end = new ListNode(carry);
            last.next = end;
        }

        return l;
    }

    private int getLength(ListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }
}
