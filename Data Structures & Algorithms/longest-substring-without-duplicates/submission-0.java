class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int[] f = new int[256];
        
        for (int i = 0, j = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            f[ch]++;

            while (f[ch] > 1) {
                f[s.charAt(j++)]--;
            }

            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
