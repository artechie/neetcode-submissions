class Solution {
    private final static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        int[] len = {rows - 1, cols};
        boolean[][] vis = new boolean[rows][cols];
        
        for (int i = 1, x = 0, y = -1; i <= 4; i++) {
            for (int j = 0; j < len[i % 2]; j++) {
                x += dir[i - 1][0];
                y += dir[i - 1][1];

                if (board[x][y] == 'O') {
                    dfs(board, x, y, vis);
                }
            }
            len[i % 2]--;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] arr, int i, int j, boolean[][] vis) {
        vis[i][j] = true;    

        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && 
                    arr[x][y] == 'O' && !vis[x][y]) {
                
                dfs(arr, x, y, vis);
            }
        }
    }
}
