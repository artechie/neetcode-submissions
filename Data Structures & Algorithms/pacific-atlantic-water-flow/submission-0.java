class Solution {
    private final static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> pac = new HashSet<>();
        Set<List<Integer>> atl = new HashSet<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (i == 0 || j == 0) {
                    dfs(heights, i, j, pac);
                } 
                if (i == heights.length - 1 || j == heights[0].length - 1) {
                    dfs(heights, i, j, atl);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                List<Integer> cell = List.of(i, j);

                if (pac.contains(cell) && atl.contains(cell)) {
                    ans.add(cell);
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] arr, int i, int j, Set<List<Integer>> vis) {
        vis.add(List.of(i, j));

        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && 
                    arr[x][y] >= arr[i][j] && !vis.contains(List.of(x, y))) {
                dfs(arr, x, y, vis);
            }
        }
    }
}
