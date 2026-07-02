class PrefixTree {
    static class Node {
        Node[] next;
        boolean isEnd;

        public Node() {
            next = new Node[26];
        }
    }

    private final Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node n = root;

        for (char ch : word.toCharArray()) {
            if (n.next[ch - 'a'] == null) {
                n.next[ch - 'a'] = new Node();
            }
            n = n.next[ch - 'a'];
        }
        n.isEnd = true;
    }

    public boolean search(String word) {
        Node n = root;

        for (char ch : word.toCharArray()) {
            if (n.next[ch - 'a'] == null) {
                return false;
            }
            n = n.next[ch - 'a'];
        }
        return n.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node n = root;

        for (char ch : prefix.toCharArray()) {
            if (n.next[ch - 'a'] == null) {
                return false;
            }
            n = n.next[ch - 'a'];
        }
        return true;
    }
}
