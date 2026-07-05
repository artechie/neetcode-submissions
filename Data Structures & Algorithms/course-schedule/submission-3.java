class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] gph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            gph[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            gph[pre[0]].add(pre[1]);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
           if (!dfs(gph, i, state)) {
            return false;
           }
        }

        return true;
    }

    private boolean dfs(List<Integer>[] gph, int src, int[] state) {
        if (state[src] == 2) {
            return true;
        }

        state[src] = 1;

        for (int nbr : gph[src]) {
            if (state[nbr] == 1 || !dfs(gph, nbr, state)) {
                return false;
            }
        }

        state[src] = 2;

        return true;
    }
}
