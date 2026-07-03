class Solution {
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] arr, int i, int j) {
        arr[i][j] = -1;

        int cells = 1;

        for (int [] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && arr[x][y] == 1) {
                cells += dfs(arr, x, y);
            }
        }
        return cells;
    }
}