package com.msb.basic;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.lintcode.common.ListNode;

public class Heap_MergeKSortedList {
    public ListNode mergeKListNode(ListNode[] nodes) {
        Comparator<ListNode> cp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(cp);

        for (ListNode n: nodes) {
            heap.add(n);
        }

        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next!=null){
            heap.add(pre.next);
        }

        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next!=null) {
                heap.add(cur.next);
            }
        }

        return head;

    }
}
