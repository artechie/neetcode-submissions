class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        if (s.equals(t)) {
            return s;
        }

        int[] f = new int[128];
        int min = s.length() + 1, cnt = 0, st = -1, end = -1;

        for (char ch : t.toCharArray()) {
            f[ch]++;
            cnt++;
        }

        for (int i = 0, j = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (--f[ch] >= 0) {
                cnt--;
            }

            while (cnt == 0) {
                if (i - j + 1 < min) {
                    min = Math.min(min, i - j + 1);
                    st = j;
                    end = i;
                }
                
                if (++f[s.charAt(j++)] > 0) {
                    cnt++;
                }
            }
        }
        return st == -1 ? "" : s.substring(st, end + 1);
    }
}
