class Solution {
    private final static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }

        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[rows - 1][i] == 'O') {
                dfs(board, rows - 1, i);
            }
        }    

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] arr, int i, int j) {
        arr[i][j] = '.';

        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && arr[x][y] == 'O') {
                dfs(arr, x, y);
            }
        }
    }
}
