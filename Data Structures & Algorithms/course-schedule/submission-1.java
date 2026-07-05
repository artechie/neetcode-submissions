class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] gph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            gph[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            gph[pre[0]].add(pre[1]);
        }

        boolean[] vis = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
           if (!dfs(gph, i, vis)) {
            return false;
           }
        }

        return true;
    }

    private boolean dfs(List<Integer>[] gph, int src, boolean[] vis) {
        vis[src] = true;

        for (int nbr : gph[src]) {
            if (vis[nbr] || !dfs(gph, nbr, vis)) {
                return false;
            }
        }

        vis[src] = false;

        return true;
    }
}
