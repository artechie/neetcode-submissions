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

        ListNode t = head, t1 = head;

        for (int i = 0; i < n; i++) {
            t = t.next;
        }

        if (t == null) {
            return head.next;
        }

        while (t.next != null) {
            t = t.next;
            t1 = t1.next;
        }

        t1.next = t1.next.next;

        return head;
    }
}
