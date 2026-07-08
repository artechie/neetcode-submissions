class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];

        if (!dfs(0, -1, g, vis)) {
            return false;
        }

        for (int i = 1; i < n; i++) {
            if (!vis[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int src, int par, List<Integer>[] g, boolean[] vis) {
        if (vis[src]) {
            return false;
        }

        vis[src] = true;

        for (int nbr : g[src]) {
            if (nbr != par && !dfs(nbr, src, g, vis)) {
                return false;
            }   
        }

        return true;
    }
}
