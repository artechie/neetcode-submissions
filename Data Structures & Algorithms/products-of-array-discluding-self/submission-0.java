class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        pref[0] = nums[0];
        int[] suf = new int[n];
        suf[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            pref[i] = nums[i] * pref[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suf[i] = nums[i] * suf[i + 1];
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int pre = i - 1 >= 0 ? pref[i - 1] : 1;
            int suff = i + 1 < n ? suf[i + 1] : 1;
            ans[i] = pre * suff;
        }

        return ans;
    }
}  
