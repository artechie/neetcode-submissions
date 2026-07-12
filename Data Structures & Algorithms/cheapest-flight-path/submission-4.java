class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        List<int[]>[] gph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            gph[i] = new ArrayList<>();
        } 

        for (int[] f : flights) {
            gph[f[0]].add(new int[] {f[1], f[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> Integer.compare(p[1], q[1]));
        pq.add(new int[] {src, 0, k + 1});

        while (!pq.isEmpty()) {
            int[] rem = pq.poll();

            if (rem[0] == dest) {
                return rem[1];
            }

            if (rem[2] == 0) continue;

            for (int[] nbr : gph[rem[0]]) {
                pq.add(new int[] {nbr[0], rem[1] + nbr[1], rem[2] - 1});
            }
        }

        return -1;
    }
}
