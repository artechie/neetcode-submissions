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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));

        for (ListNode n : lists) {
            pq.add(n);
        }

        ListNode dummy = new ListNode(-1), l = dummy;

        while (!pq.isEmpty()) {
            ListNode rem = pq.remove();

            l.next = new ListNode(rem.val);
            l = l.next;

            if (rem.next != null) {
                pq.add(rem.next);
            }
        }

        return dummy.next;
    }
}
