class Solution {
    static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int orangesRotting(int[][] grid) {
        Deque<int[]> dq = new ArrayDeque<>();
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    dq.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;

        while (!dq.isEmpty()) {
            int size = dq.size();

            time++;

            while (size-- > 0) {
                int[] rem = dq.poll();

                for (int[] d : dir) {
                    int x = rem[0] + d[0];
                    int y = rem[1] + d[1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        dq.add(new int[]{x, y});
                        fresh--;

                        if (fresh == 0) {
                            return time;
                        }
                    }
                }
            }
        }
        return fresh == 0 ? 0 : -1;
    }
}
