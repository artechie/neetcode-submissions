class Solution {
    public int maxProduct(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int currMax = 1, currMin = 1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currMin = 1;
                currMax = 1;
                continue;
            }
            int v1 = currMax * nums[i];
            int v2 = currMin * nums[i];

            currMax = Math.max(nums[i], Math.max(v1, v2));
            currMin = Math.min(nums[i], Math.min(v1, v2));

            max = Math.max(max, Math.max(currMax, currMin));
        }
        return max;
    }
}
