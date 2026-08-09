class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> tails = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int insertionIdx = getInsertionIdx(tails, nums[i]);

            if (insertionIdx == tails.size()) {
                tails.add(nums[i]);
            } else {
                tails.set(insertionIdx, nums[i]);
            }
        }

        return tails.size();
    }

    private int getInsertionIdx(List<Integer> tails, int tar) {
        int l = 0, r = tails.size();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (tar > tails.get(mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
