class Solution {
    static class Node {
        Node[] chars = new Node[26];
        String word;
    }
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}; 

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();

        for (String word : words) {
            add(word, root);
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                solve(i, j, board, root, ans);
            }
        }

        return ans;
    }

    private void add(String word, Node root) {
        for (char ch : word.toCharArray()) {
            if (root.chars[ch - 'a'] == null) {
                root.chars[ch - 'a'] = new Node();
            }
            root = root.chars[ch - 'a'];
        }
        root.word = word;
    }

    private void solve(int i, int j, char[][] arr, Node root, List<String> ans) {
        char ch = arr[i][j];
        
        root = root.chars[ch - 'a'];

        if (root == null) {
            return;
        }

        if (root.word != null) {
            ans.add(root.word);
            root.word = null; 
        }

        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (!(x < 0 || y < 0 || x >= arr.length || y >= arr[0].length || arr[x][y] == '.')) {
                arr[i][j] = '.';

                solve(x, y, arr, root, ans);

                arr[i][j] = ch;
            }
        }
    }
}