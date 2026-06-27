class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[128];

        for (char task : tasks) {
            freq[task]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Deque<int[]> dq = new ArrayDeque<>();

        for (int f : freq) {
            if (f > 0) {
                pq.add(f);
            }
        }
        
        int t = 1;

        while (!pq.isEmpty()) {
            int rem = pq.poll();

            if (rem - 1 > 0) {
                dq.add(new int[] {rem - 1, t + n + 1});
            }

            t++;

            if (!dq.isEmpty() && dq.peek()[1] == t) {
                pq.add(dq.poll()[0]);
            }

            if (pq.isEmpty() && !dq.isEmpty()) {
                t = dq.peek()[1];
                pq.add(dq.poll()[0]);
            }
        }
        return t - 1;
    }
}
