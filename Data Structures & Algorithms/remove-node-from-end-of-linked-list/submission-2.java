/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head), t = head, t1 = dummy;

        for (int i = 0; i < n; i++) {
            t = t.next;
        }

        while (t != null) {
            t = t.next;
            t1 = t1.next;
        }

        t1.next = t1.next.next;

        return dummy.next;
    }
}
