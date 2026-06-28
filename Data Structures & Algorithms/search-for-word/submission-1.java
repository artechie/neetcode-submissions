class Solution {
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (solve(board, word, 0, i, j)) {
                    return true;
                }  
            }
        }
        return false;
    }

    private boolean solve(char[][] arr, String s, int idx, int i, int j) {
        if (idx == s.length()) {
            return true;
        }

        if (!(i >= 0 && i < arr.length && j >= 0 && j < arr[0].length && arr[i][j] != '#')) {
            return false;
        }

        if (s.charAt(idx) != arr[i][j]) {
            return false;
        }

        char ch = arr[i][j];
        arr[i][j] = '#';

        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (solve(arr, s, idx + 1, x, y)) {
                return true;
            }
        }

        arr[i][j] = ch;

        return false;
    }
}
