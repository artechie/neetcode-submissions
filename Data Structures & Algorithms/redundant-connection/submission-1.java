class Solution {
    private int[] par;
    private int[] size;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        par = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            par[i] = i;
            size[i] = 1;
        }

        for (int[] e : edges) {
            if (union(e[0], e[1])) {
                return e;
            }
        }

        return new int[0];
    }

    private boolean union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);

        if (root1 == root2) return true;

        if (size[root1] > size[root2]) {
            par[root2] = root1;
            size[root1] += size[root2];
        } else {
            par[root1] = root2;
            size[root2] += size[root1];
        }

        return false;
    }

    private int find(int x) {
        if (par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]);
    }
}
