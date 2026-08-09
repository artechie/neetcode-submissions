class Solution {
    static class Node {
        Node[] chr = new Node[26];
        boolean isEnd;
    }

    private Node root = new Node();

    public boolean wordBreak(String s, List<String> wordDict) {
        Node n;
        int len = s.length();

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

        boolean[] dp = new boolean[len + 1];
        dp[len] = true;
        
        for (int i = len - 1; i >= 0; i--) {
            Node tmp = root;
            for (int j = i; j < len; j++) {
                char ch = s.charAt(j);

                tmp = tmp.chr[ch - 'a'];

                if (tmp == null) {
                    break;
                }

                if (tmp.isEnd) {
                    dp[i] = dp[j + 1];

                    if (dp[i]) break;
                }
            }
        }

        return dp[0];
    }
}
