class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        return solve(0, 0, nums, new Integer[n + 1][2]);
    }

    private int solve(int idx, int isFirstTaken, int[] nums, Integer[][] dp) {
        if (idx == nums.length - 1 && isFirstTaken == 1) {
            return 0;
        }

        if (idx >= nums.length) {
            return 0;
        }

        if (dp[idx][isFirstTaken] != null) {
            return dp[idx][isFirstTaken];
        }

        return dp[idx][isFirstTaken] = Math.max(solve(idx + 1, isFirstTaken, nums, dp), 
                                    solve(idx + 2, idx == 0 ? 1 : isFirstTaken, nums, dp) + nums[idx]);
    }
}
