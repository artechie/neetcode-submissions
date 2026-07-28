class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);

            if (ch != '0') {
                dp[i] += dp[i - 1];
            } 

            if (i >= 2) {
                int num = (s.charAt(i - 2) - '0') * 10 + (ch - '0');

                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}
