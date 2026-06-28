class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        solve(candidates, 0, new ArrayList<>(), ans, target);

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
            solve(arr, idx + 1, curr, ans, sum - arr[idx]);
            curr.remove(curr.size() - 1);
        }

        while (idx < arr.length - 1 && arr[idx] == arr[idx + 1]) {
            idx++;
        }

        solve(arr, idx + 1, curr, ans, sum);
    }
}
