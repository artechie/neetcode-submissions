class WordDictionary {
    static class Node {
        Node[] next;
        boolean isEnd;

        public Node() {
            next = new Node[26];
        }
    }

    private final Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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
        return searchHelper(root, word);
    }

    private boolean searchHelper(Node n, String word) {
        if (word.equals("")) {
            return n.isEnd;
        }

        int idx = 0;

        for (char ch : word.toCharArray()) {
            if (ch == '.') {
                for (Node node : n.next) {
                    if (node != null) {
                        if (searchHelper(node, word.substring(idx + 1))) {
                            return true;
                        }
                    }
                }
                return false;
            } else if (n.next[ch - 'a'] == null) {
                return false;
            }
            n = n.next[ch - 'a'];

            idx++;
        }
        return n.isEnd;
    }
}
