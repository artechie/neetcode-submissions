class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> Integer.compare((q[0] * q[0] + q[1] * q[1]), (p[0] * p[0] + p[1] * p[1])));

        for (int[] p : points) {
            pq.add(p);

            if (pq.size() > k) {
                pq.remove();
            }
        }

        int i = 0;

        while (!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }
        return ans;
    }
}
