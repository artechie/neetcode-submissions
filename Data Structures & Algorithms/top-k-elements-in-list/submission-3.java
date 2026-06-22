class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        Set<Integer>[] buckets = new HashSet[nums.length + 1];
        int[] ans = new int[k];

        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new HashSet<>();
        }

        for (int n : nums) {
            int currFreq = map.getOrDefault(n, 0);
            map.put(n, currFreq + 1);

            if (currFreq > 0) {
                buckets[currFreq].remove(n);
            }
            buckets[currFreq + 1].add(n);
        }

        for (int i = buckets.length - 1, j = 0; i >= 0 && j < k; i--) {
            for (int n : buckets[i]) {
                if (j == k) {
                    return ans;
                }
                ans[j++] = n;
            }
        }

        return ans;
    }
}
