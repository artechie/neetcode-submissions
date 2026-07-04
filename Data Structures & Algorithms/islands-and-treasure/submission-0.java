class Solution {
    static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    static final int MAX = (int)Math.pow(2, 31);

    public void islandsAndTreasure(int[][] grid) {
        System.out.println(MAX);
        Deque<int[]> dq = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dq.add(new int[]{i, j});
                }
            }
        }

        int lvl = 0;

        while (!dq.isEmpty()) {
            lvl++;

            int size = dq.size();

            while (size-- > 0) {
                int[] rem = dq.poll();

                for (int[] d : dir) {
                    int x = rem[0] + d[0];
                    int y = rem[1] + d[1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == MAX) {
                        grid[x][y] = lvl;
                        dq.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
