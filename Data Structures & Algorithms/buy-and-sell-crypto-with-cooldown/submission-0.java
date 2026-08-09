class Solution {
    public int maxProfit(int[] prices) {
        return solve(prices, 0, prices.length, 1, new Integer[prices.length][prices.length + 1][2]);
    }

    private int solve(int[] arr, int idx, int prev, int cooldown, Integer[][][] dp) {
        if (idx >= arr.length) {
            return 0;
        }

        if (dp[idx][prev][1] != null) {
            return dp[idx][prev][1];
        }

        int max = 0;

        if (prev != arr.length) {
            max = Math.max(max, solve(arr, idx + 1 + cooldown, arr.length, cooldown, dp) + (arr[idx] - arr[prev]));
        }

        max = Math.max(max, solve(arr, idx + 1, idx, cooldown, dp));

        max = Math.max(max, solve(arr, idx + 1, prev, cooldown, dp));

        return dp[idx][prev][1] = max;
    }
}
