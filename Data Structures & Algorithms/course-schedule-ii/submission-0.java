class Solution {
    public int[] findOrder(int num, int[][] pre) {
        List<Integer>[] g = new ArrayList[num];
        int[] deps = new int[num];

        for (int i = 0; i < num; i++) {
            g[i] = new ArrayList<>();
        }

        for (int p[] : pre) {
            g[p[1]].add(p[0]);
            deps[p[0]]++;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[num];
        int idx = 0;

        for (int i = 0; i < num; i++) {
            if (deps[i] == 0) {
                dq.offer(i);
            }
        }

        while (!dq.isEmpty()) {
            int rem = dq.poll();

            ans[idx++] = rem;

            for (int nbr : g[rem]) {
                if (--deps[nbr] == 0) {
                    dq.offer(nbr);
                }
            }
        }

        if (idx < num) {
            return new int[0];
        }

        return ans;
    }
}