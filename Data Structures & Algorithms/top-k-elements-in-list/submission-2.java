class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Deque<Integer>[] buckets = new ArrayDeque[nums.length + 1];
        int[] ans = new int[k];

        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayDeque<>();
        }

        for (int key : map.keySet()) {
            buckets[map.get(key)].add(key);
        }

        for (int i = nums.length, j = 0; i >= 0 && j < k; i--) {
            while (j < k && !buckets[i].isEmpty()) {
                ans[j++] = buckets[i].remove();
            }
        }

        return ans;
    }
}
