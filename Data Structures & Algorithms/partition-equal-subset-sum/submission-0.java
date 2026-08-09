class Solution {
    public boolean canPartition(int[] nums) {
        // dp[i][j] -> given i elements in array, can we form sum j

        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0)
            return false;

        int tar = sum / 2, n = nums.length;
        boolean[][] dp = new boolean[n + 1][tar + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= tar; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]]) {
                    dp[i][j] = true;
                }
            } 
        }

        return dp[n][tar];
    }
}
