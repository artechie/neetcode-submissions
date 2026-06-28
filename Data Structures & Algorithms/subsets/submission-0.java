class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(int[] arr, int idx, List<Integer> curr, List<List<Integer>> ans) {
        if (idx == arr.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(arr[idx]);
        solve(arr, idx + 1, curr, ans);
        curr.remove(curr.size() - 1);

        solve(arr, idx + 1, curr, ans);
    }
}
