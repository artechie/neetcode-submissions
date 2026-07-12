class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int lo, int hi) {
        int[] dp = new int[nums.length];
        dp[lo] = nums[lo];

        for (int i = lo + 1; i <= hi; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + (i >= 2 ? dp[i - 2] : 0));
        }

        return dp[hi];
    }
}
