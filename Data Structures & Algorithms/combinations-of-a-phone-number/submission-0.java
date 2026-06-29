class Solution {
    static String[] dig = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String s) {
        List<String> ans = new ArrayList<>();
        
        solve(s, 0, "", ans);

        return ans;
    }

    private void solve(String s, int idx, String curr, List<String> ans) {
        if (idx == s.length()) {
            if (curr.length() > 0) {
                ans.add(curr);
            }
            return;
        }

        for (char ch : dig[s.charAt(idx) - '0'].toCharArray()) {
            solve(s, idx + 1, curr + ch, ans);
        }
    }
}
