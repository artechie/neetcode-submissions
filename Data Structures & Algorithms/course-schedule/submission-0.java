class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<Integer>[] gph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            gph[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            in[pre[0]]++;
            gph[pre[1]].add(pre[0]);
        }

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                dq.add(i);
            }
        }

        while (!dq.isEmpty()) {
            int rem = dq.poll();

            for (int nbr : gph[rem]) {
                if (--in[nbr] == 0) {
                    dq.add(nbr);
                }
            }
        }

        for (int i : in) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
