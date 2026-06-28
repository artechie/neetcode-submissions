class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(nums, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        if (nums.length == curr.size()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 11) {
                int t = nums[i];
                curr.add(t);
                nums[i] = 11;
                solve(nums, curr, ans);
                curr.remove(curr.size() - 1);
                nums[i] = t;
            }
        }
    }
}
