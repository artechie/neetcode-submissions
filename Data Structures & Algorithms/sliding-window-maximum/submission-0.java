class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            if (i - k >= 0 && dq.peek() <= i - k) {
                dq.poll();
            }

            if (i - k + 1 >= 0) {
                ans[idx++] = nums[dq.peek()];
            }
        }
        return ans;
    }
}
