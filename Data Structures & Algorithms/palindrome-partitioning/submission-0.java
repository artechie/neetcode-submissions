class Solution {
    public List<List<String>> partition(String s) {
        return solve(s);
    }

    private List<List<String>> solve(String s) {
        if (s.length() == 0) {
            List<List<String>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (isPalin(s, 0, i)) {
                String sub = s.substring(0, i + 1);
                List<List<String>> res = solve(s.substring(i + 1));

                for (List<String> l : res) {
                    List<String> temp = new ArrayList<>(List.of(sub));
                    temp.addAll(l);
                    ans.add(temp);
                }
            }
        }
        return ans;
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
