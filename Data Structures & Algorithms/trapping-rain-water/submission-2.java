class Solution {
    public int trap(int[] nums) {
        int max = 0, i = 1, j = 0;

        while (i < nums.length) {
            if (nums[i] >= nums[j]) {
                int sum = 0, h = Math.min(nums[i], nums[j]);
                j++;

                while (j < i) {
                    sum += (h - nums[j]);
                    j++;
                }
                max += sum;
            }
            i++;
        }

        int rmax = nums.length - 1, sum = 0;
        i = nums.length - 2;

        while (i > j) {
            if (nums[i] >= nums[rmax]) {
                max += sum;

                sum = 0;

                rmax = i;
            }
            sum += (nums[rmax] - nums[i]);
            i--;
        }
        return max + sum;
    }
}
