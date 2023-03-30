package com.lintcode.daily;

import com.lintcode.common.ListNode;

/**
 * <p>https://www.lintcode.com/problem/450/description</p>
 */
public class Code450_ReverseNodesInKGroup {
    /**
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // write your code here
        ListNode end = dummy;
        ListNode pre = dummy;
        while (end != null) {
            for (int i=0; i<k && end!=null; i++) {
                end = end.next;                
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre =start;
            end = pre;
            
        }
        return dummy.next;

    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
