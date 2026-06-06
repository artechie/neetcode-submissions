class Solution {
    public int trap(int[] nums) {
        int i = 0, j = nums.length - 1, lmax = nums[0], rmax = nums[nums.length - 1], ans = 0;

        while (i < j) {
            if (nums[i] < nums[j]) {
                i++;
                lmax = Math.max(lmax, nums[i]);
                ans += lmax - nums[i];
            } else {
                j--;
                rmax = Math.max(rmax, nums[j]);
                ans += rmax - nums[j];
            }
        }
        return  ans;
    }   
}
