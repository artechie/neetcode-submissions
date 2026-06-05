class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        int max = 0;

        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            int cnt = 1, n = num + 1;

            while (set.contains(n)) {
                n++;
                cnt++;
            }
            max = Math.max(max, cnt);
        }

        return max;
    }
}
