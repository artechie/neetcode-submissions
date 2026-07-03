class Solution {
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int cnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] ch, int i, int j) {
        ch[i][j] = '.';

        for (int [] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < ch.length && y >= 0 && y < ch[0].length && ch[x][y] == '1') {
                dfs(ch, x, y);
            }
        }
    }
}