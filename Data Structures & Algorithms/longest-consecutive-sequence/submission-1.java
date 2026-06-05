class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        Set<Integer> vis = new HashSet<>();

        for (int num : set) {
            if (vis.contains(num)) {
                continue;
            }

            int cnt = 1, n = num + 1;

            vis.add(num);

            while (set.contains(n)) {
                vis.add(n);

                if (map.containsKey(n)) {
                    map.put(num, cnt + map.get(n));
                    max = Math.max(max, cnt + map.get(n));
                    map.remove(n);
                    break;
                }

                n++;
                cnt++;
            }

            if (!map.containsKey(num)) {
                map.put(num, cnt);
                max = Math.max(max, cnt);
            }
        }

        return max;
    }
}
