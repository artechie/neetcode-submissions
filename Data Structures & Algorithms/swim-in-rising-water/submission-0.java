class Solution {
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> Integer.compare(p[2], q[2]));
        pq.add(new int[] {0, 0, grid[0][0]});
        int max = grid[0][0];

        while (!pq.isEmpty()) {
            int[]  rem = pq.poll();
            int i = rem[0], j = rem[1];

            max = Math.max(max, rem[2]);

            if (i == m - 1 && j == n - 1) {
                return max;
            }

            grid[i][j] = -1;

            for (int[] d : dir) {
                int x = i + d[0];
                int y = j + d[1];

                if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] != -1) {
                    pq.add(new int[] {x, y, grid[x][y]});
                }
            }
        }

        return grid[0][0];
    }
}
