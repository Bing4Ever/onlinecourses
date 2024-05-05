package com.msb.basic;

import com.lintcode.common.ListNode;

public class LinkedList_ReversenNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }

        head = end;
        reverse(start, end);
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }

            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    private ListNode getKGroupEnd(ListNode n, int k) {
        while (--k != 0 && n != null) {
            n = n.next;
        }
        return n;
     }

     public void reverse(ListNode start, ListNode end) {
        end  = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
     }
}
