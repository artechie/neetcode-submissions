class Solution {
    public int search(int[] nums, int target) {
        int l = 0, n = nums.length, r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        if (target >= nums[l] && target <= nums[n - 1]) {
            return search(nums, target, l, n - 1);
        }
        return search(nums, target, 0, l - 1);
    }

    private int search(int[] nums, int target, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
