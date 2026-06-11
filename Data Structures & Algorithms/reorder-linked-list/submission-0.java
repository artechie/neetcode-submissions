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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode s = head, f = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }

        ListNode h2 = reverse(s);
        ListNode h1 = head, temp = new ListNode(-1, head);
        boolean flag = true;

        while (h1 != null && h2 != null) {
            if (flag) {
                temp.next = h1;
                h1 = h1.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
            flag = !flag;
        }

        if (h2 != null) {
            temp.next = h2;
            temp = temp.next;
        }
        temp.next = null;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head, prev = null, next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}