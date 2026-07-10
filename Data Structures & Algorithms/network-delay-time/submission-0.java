class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] d = new int[n + 1];

        Arrays.fill(d, Integer.MAX_VALUE);

        d[k] = 0;

        int max = 0;

        List<int[]>[] g = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] t : times) {
            g[t[0]].add(new int[] {t[1], t[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
        pq.add(new int[] {k, 0});

        while (!pq.isEmpty()) {
            int[] rem = pq.poll();

            for (int[] nbr : g[rem[0]]) {
                if (nbr[1] + rem[1] < d[nbr[0]]) {
                    d[nbr[0]] = rem[1] + nbr[1];
                    pq.add(new int[] {nbr[0], d[nbr[0]]});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (d[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, d[i]);
        }

        return max;
    }
}
