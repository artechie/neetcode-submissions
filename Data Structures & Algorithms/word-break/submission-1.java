class Solution {
    static class Node {
        Node[] chr = new Node[26];
        boolean isEnd;
    }

    private Node root = new Node();

    public boolean wordBreak(String str, List<String> wordDict) {
        Node n;

        for (String w : wordDict) {
            n = root;
            for (char ch : w.toCharArray()) {
                if (n.chr[ch - 'a'] == null) {
                   n.chr[ch - 'a'] = new Node(); 
                }
                n = n.chr[ch - 'a'];
            }
            n.isEnd = true;
        }

        return solve(str, root, 0, new Boolean[str.length()]);
    }

    private boolean solve(String s, Node n, int idx, Boolean[] dp) {
        if (idx == s.length()) {
            return true;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        Node tmp = n;

        for (int i = idx; i < s.length(); i++) {
            char ch = s.charAt(i);

            tmp = tmp.chr[ch - 'a'];

            if (tmp == null) {
                break;
            }

            if (tmp.isEnd && solve(s, n, i + 1, dp)) {
                return true;
            }
        }

        return dp[idx] = false;
    }
}
