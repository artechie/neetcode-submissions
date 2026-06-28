class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        solve(2 * n, n, n, "", ans);

        return ans;
    }

    private void solve(int n, int op, int cl, String curr, List<String> ans) {
        if (n == curr.length()) {
            ans.add(curr);
            return;
        }

        if (op > 0) {
            solve(n, op - 1, cl, curr + "(", ans);
        }

        if (op < cl) {
            solve(n, op, cl - 1, curr + ")", ans);
        }
    }
}
