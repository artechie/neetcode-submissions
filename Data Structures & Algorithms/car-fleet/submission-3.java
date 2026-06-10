class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }

        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        Deque<Double> dq = new ArrayDeque<>();
        int zeros = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i][1] == 0) {
                zeros++;
                continue;
            }
            double time = (target - arr[i][0]) / (double)arr[i][1];
            
            while (!dq.isEmpty() && dq.peek() <= time) {
                dq.poll();
            }
            dq.push(time);
        }
        return dq.size() + zeros;
    }
}
