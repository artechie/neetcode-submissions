class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        solve(nums, 0, new ArrayList<>(), ans, target);

        return ans;
    }

    private void solve(int[] arr, int idx, List<Integer> curr, List<List<Integer>> ans, int sum) {
        if (sum == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (idx == arr.length || sum - arr[idx] < 0) {
            return;
        }

        if (sum >= arr[idx]) {
            curr.add(arr[idx]);
            solve(arr, idx, curr, ans, sum - arr[idx]);
            curr.remove(curr.size() - 1);
        }

        solve(arr, idx + 1, curr, ans, sum);
    }
}
