class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] freq = new int[128];
        int max = 0, maxFreq = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            maxFreq = Math.max(maxFreq, ++freq[ch]);

            if ((i - j + 1) - maxFreq > k) {
                freq[s.charAt(j++)]--;  
            }

            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
