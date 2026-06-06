class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (i > 0 && num == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int s = nums[i] + nums[j];
                Integer idx = map.get(-s);
                
                if (idx != null && idx > j) {
                    ans.add(List.of(nums[i], nums[j], -s));
                }
            }
        }
        return ans;
    }
}
