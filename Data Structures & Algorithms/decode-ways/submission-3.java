class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }

        return solve(s.toCharArray(), 0, new Integer[n]);
    }

    private int solve(char[] ch, int idx, Integer[] dp) {
        if (idx == ch.length) {
            return 1;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        int cnt = 0;

        if (ch[idx] != '0') {
            cnt += solve(ch, idx + 1, dp);
        }

        if (idx < ch.length - 1) {
            int num = (ch[idx] - '0') * 10 + (ch[idx + 1] - '0');

            if (num >= 10 && num <= 26) {
                cnt += solve(ch, idx + 2, dp);
            }
        }

        return dp[idx] = cnt;
    }
}
