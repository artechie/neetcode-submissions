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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head), t = head;
        int cnt = 0;

        while (t != null) {
            t = t.next;
            cnt++;
        }

        ListNode curr = head, next = null, prePrev = dummy, prev = dummy;

        for (int i = 0; i < cnt / k; i++) {
            int n = k;

            ListNode first = curr;

            while (n-- > 0) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            } 
            prePrev.next = prev;
            prePrev = first;
        }

        if (curr != null) {
            prePrev.next = curr;
        } else {
            prePrev.next = null;
        }

        return dummy.next;
    }
}
