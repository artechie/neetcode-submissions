class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Set<Integer> vis = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> Integer.compare(p[1], q[1]));
        pq.add(new int[] {0, 0});

        int cost = 0;

        while (vis.size() < n) {
            int[] rem = pq.poll();

            if (vis.contains(rem[0])) {
                continue;
            }

            vis.add(rem[0]);

            for (int i = 0; i < n; i++) {
                if (vis.contains(i)) {
                    continue;
                }

                int[] src = points[rem[0]];
                int[] tar = points[i];
                int dis = Math.abs(src[0] - tar[0]) + Math.abs(src[1] - tar[1]);

                pq.add(new int[] {i, dis});
            }
            
            cost += rem[1];
        }

        return cost;
    }
}