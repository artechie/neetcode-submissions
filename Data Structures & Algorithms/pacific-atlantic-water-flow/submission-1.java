class Solution {
    private final static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    dfs(heights, i, j, pac);
                } 
                if (i == rows - 1 || j == cols - 1) {
                    dfs(heights, i, j, atl);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pac[i][j] && atl[i][j]) {
                    ans.add(List.of(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] arr, int i, int j, boolean[][] vis) {
        vis[i][j] = true;       

        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && 
                    arr[x][y] >= arr[i][j] && !vis[x][y]) {
                dfs(arr, x, y, vis);
            }
        }
    }
}
