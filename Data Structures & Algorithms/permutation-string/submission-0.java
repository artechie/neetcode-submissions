class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] freq = new int[128];
        int cnt = 0;

        for (char ch : s1.toCharArray()) {
            freq[ch]++;
            cnt++;
        }

        for (int i = 0, j = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);

            if (--freq[ch] >= 0) {
                cnt--;
            } else {
                while (freq[ch] < 0) {
                    if (++freq[s2.charAt(j++)] > 0) {
                        cnt++;
                    } 
                }
            }

            if (cnt == 0) {
                return true;
            }
        }
        return false;
    }
}
