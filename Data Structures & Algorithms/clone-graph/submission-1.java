/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        return dfs(node, new HashMap<>());
    }

    private Node dfs(Node curr, Map<Integer, Node> gph) {
        Node n = new Node(curr.val);

        gph.put(curr.val, n);

        for (Node nbr : curr.neighbors) {
            if (!gph.containsKey(nbr.val)) {
                n.neighbors.add(dfs(nbr, gph));
            } else {
                n.neighbors.add(gph.get(nbr.val));
            }
        }
        return n;
    }
}