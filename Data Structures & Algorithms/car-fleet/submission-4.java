class Solution {
    public int carFleet(int tar, int[] p, int[] s) {
        int n = p.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{p[i], s[i]};
        }

        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        Deque<Double> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            double t = (double)(tar - arr[i][0]) / arr[i][1];

            if (!st.isEmpty() && t <= st.peek()) {
                continue;
            }
            st.push(t);
        }
        return st.size();
    }
}
