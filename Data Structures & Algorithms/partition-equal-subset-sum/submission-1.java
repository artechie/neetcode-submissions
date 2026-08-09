class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0)
            return false;

        int tar = sum / 2, n = nums.length;
        boolean[] dp = new boolean[tar + 1];

        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = tar; j >= 0; j--) {
                dp[j] = dp[j];

                if (j >= nums[i - 1] && dp[j - nums[i - 1]]) {
                    dp[j] = true;
                }
            } 
        }

        return dp[tar];
    }
}
