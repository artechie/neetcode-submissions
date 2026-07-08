class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }
        
        List<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {0, -1});
        
        vis[0] = true;

        while (!dq.isEmpty()) {
            int[] rem = dq.poll();

            for (int nbr : g[rem[0]]) {
                if (nbr == rem[1]) {
                    continue;
                }
                
                if (vis[nbr]) {
                    return false;
                }

                dq.add(new int[] {nbr, rem[0]});
                vis[nbr] = true;
            }
        }

        for (int i = 1; i < n; i++) {
            if (!vis[i]) {
                return false;
            }
        }

        return true;
    }
}
