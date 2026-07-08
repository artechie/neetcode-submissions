class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, g, vis);
                cnt++;
            }
        }

        return cnt;
    }

    private void dfs(int src, int par, List<Integer>[] g, boolean[] vis) {
        if (vis[src]) {
            return;
        }

        vis[src] = true;

        for (int nbr : g[src]) {
            if (nbr == par) {
                continue;
            }

            dfs(nbr, src, g, vis);
        }
    }
}
