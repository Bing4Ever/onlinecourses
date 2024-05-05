package com.msb.basic;

import static org.junit.Assert.assertEquals;

import com.lintcode.common.ListNode;

import org.junit.Before;
import org.junit.Test;

public class LinkedList_AddTwoNumbersTest {
    private LinkedList_AddTwoNumbers target;

    @Before
    public void init() {
        this.target = new LinkedList_AddTwoNumbers();
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode head1 = new ListNode(2);
        ListNode node11 = new ListNode(3);
        ListNode node12 = new ListNode(8);
        head1.next = node11;
        node11.next = node12;
        
        ListNode head2 = new ListNode(4);
        ListNode node21 = new ListNode(8);
        head2.next = node21;

        ListNode result = this.target.addTwoNumbers(head1, head2);

        assertEquals(6, result.val);
        assertEquals(1, result.next.val);
        assertEquals(9, result.next.next.val);

    }
}
