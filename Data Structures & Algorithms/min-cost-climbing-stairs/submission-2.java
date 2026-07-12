class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Integer[] dp = new Integer[cost.length + 1];
        
        return Math.min(solve(0, cost, dp), solve(1, cost, dp));
    }

    private int solve(int idx, int[] cost, Integer[] dp) {
        if (idx == cost.length) {
            return 0;
        }

        if (idx > cost.length) {
            return 101;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        return dp[idx] = Math.min(solve(idx + 1, cost, dp), solve(idx + 2, cost, dp)) + cost[idx];
    }
}
