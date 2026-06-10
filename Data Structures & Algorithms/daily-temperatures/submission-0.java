class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[temp.length];

        for (int i = temp.length - 1; i >= 0; i--) {
            while (!dq.isEmpty() && temp[i] >= temp[dq.peek()]) {
                dq.pop();
            }

            if (!dq.isEmpty()) {
                ans[i] = dq.peek() - i;
            }

            dq.push(i);
        }
        return ans;
    }
}
