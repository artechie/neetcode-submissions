class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] f : flights) {
            g[f[0]].add(new int[] {f[1], f[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[1], p2[1]));
        pq.add(new int[] {src, 0, k + 1});

        int[][] d = new int[n][k + 2];
        for (int[] arr : d) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        d[src][k] = 0;

        while (!pq.isEmpty()) {
            int[] rem = pq.poll();

            if (rem[0] == dst) {
                return rem[1];
            }

            if (rem[2] == 0) {
                continue;
            }

            for (int[] nbr : g[rem[0]]) {
                int dis = rem[1] + nbr[1];

                if (dis < d[nbr[0]][rem[2]]) {
                    d[nbr[0]][rem[2]] = dis;

                    pq.add(new int[] {nbr[0], dis, rem[2] - 1});
                }   
            }
        }

        return -1;
    }
}
