class Solution {
    public int maxProfit(int[] prices) {
        // buy -> 0, rest -> 1
        // state = 0 → holding stock, next action is sell/rest
        // state = 1 → allowed to buy
        return solve(prices, 0, 1, new Integer[prices.length][2]);
    }

    private int solve(int[] arr, int idx, int state, Integer[][] dp) {
        if (idx >= arr.length) {
            return 0;
        }

        if (dp[idx][state] != null) {
            return dp[idx][state];
        }

        int max = 0;

        if (state == 1) {
            int m1 = solve(arr, idx + 1, 0, dp) - arr[idx];
            int m2 = solve(arr, idx + 1, 1, dp);
            max = Math.max(max, Math.max(m1, m2));
        } else {
            int m1 = solve(arr, idx + 2, 1, dp) + arr[idx];
            int m2 = solve(arr, idx + 1, 0, dp);
            max = Math.max(max, Math.max(m1, m2));
        }

        return dp[idx][state] = max;
    }
}
