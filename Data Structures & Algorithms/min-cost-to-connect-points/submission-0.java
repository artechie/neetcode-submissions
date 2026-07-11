class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Set<Integer> vis = new HashSet<>();
        int[] d = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> Integer.compare(p[1], q[1]));
        pq.add(new int[] {0, 0});

        Arrays.fill(d, Integer.MAX_VALUE);

        d[0] = 0;

        while (!pq.isEmpty()) {
            int[] rem = pq.poll();

            vis.add(rem[0]);

            if (vis.size() == n) {
                break;
            }

            for (int i = 0; i < n; i++) {
                if (vis.contains(i)) {
                    continue;
                }

                int[] src = points[rem[0]];
                int[] tar = points[i];
                int dis = Math.abs(src[0] - tar[0]) + Math.abs(src[1] - tar[1]);

                if (dis < d[i]) {
                    d[i] = dis;
                    pq.add(new int[] {i, d[i]});
                }
            }
        }

        System.out.println(Arrays.toString(d));

        return Arrays.stream(d).sum();
    }
}