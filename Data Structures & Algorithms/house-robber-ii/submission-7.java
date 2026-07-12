class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + (i >= 2 ? dp[i - 2] : 0));
        }

        int max = dp[n - 2];

        dp = new int[n];
        dp[1] = nums[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return Math.max(max, dp[n - 1]);
    }
}
