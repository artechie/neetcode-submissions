/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1), t1 = head, t2 = dummy;

        while (t1 != null) {
            t2.next = new Node(t1.val);
            map.put(t1, t2.next);
            t1 = t1.next;
            t2 = t2.next;
        }

        t1 = head;
        t2 = dummy.next;

        while (t1 != null) {
            t2.random = t1.random == null ? null : map.get(t1.random);
            t1 = t1.next;
            t2 = t2.next;
        }
        return dummy.next;
    }
}
