package com.msb.basic;

import static org.junit.Assert.assertEquals;

import com.lintcode.common.ListNode;

import org.junit.Before;
import org.junit.Test;

public class Heap_MergeKSortedListTest {
    private Heap_MergeKSortedList target;

    @Before
    public void init() {
        this.target = new Heap_MergeKSortedList();
    }

    @Test
    public void testMergeKListNode() {
        ListNode o1 = new ListNode(2);
        ListNode o2 = new ListNode(28);
        ListNode o3 = new ListNode(123);
        o1.next = o2;
        o2.next = o3;
        ListNode m1 = new ListNode(23);
        ListNode m2 = new ListNode(441);
        ListNode m3 = new ListNode(991);
        m1.next = m2;
        m2.next = m3;

        ListNode[] arr = {o1, m1};
        ListNode result = this.target.mergeKListNode(arr);

        assertEquals(2, result.val);
        assertEquals(23, result.next.val);
        assertEquals(28, result.next.next.val);

    }
}
