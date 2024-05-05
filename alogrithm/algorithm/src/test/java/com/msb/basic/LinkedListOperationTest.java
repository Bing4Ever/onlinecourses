package com.msb.basic;

import static org.junit.Assert.assertEquals;

import com.lintcode.common.DoubleNode;
import com.lintcode.common.ListNode;

import org.junit.Before;
import org.junit.Test;

public class LinkedListOperationTest {
    private LinkedListOperation target;

    @Before
    public void init() {
        this.target = new LinkedListOperation();
    }

    @Test
    public void testReverseDoubleLinkedList() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        ListNode res = this.target.reverseLinkedList(a);
        int num = 3;
        while(res != null){
            assertEquals(num, res.val);
            num--;
            res = res.next;
        }

    }

    @Test
    public void testReverseLinkedList() {
        DoubleNode a = new DoubleNode(1);
        DoubleNode b = new DoubleNode(2);
        DoubleNode c = new DoubleNode(3);
        a.next = b;
        b.next = c;
        b.last = a;
        c.last = b;
        DoubleNode res = this.target.reverseDoubleLinkedList(a);
        assertEquals(3, res.val);
        assertEquals(2, res.next.val);
        assertEquals(1, res.next.next.val);
        assertEquals(3, res.next.last.val);
        assertEquals(2, res.next.next.last.val);
    }
}
