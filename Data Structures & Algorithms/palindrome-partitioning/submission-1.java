class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        solve(s, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(String s, int idx, List<String> curr, List<List<String>> ans) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(curr));
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalin(s, idx, i)) {
                String sub = s.substring(idx, i + 1);

                curr.add(sub);
                solve(s, i + 1, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
