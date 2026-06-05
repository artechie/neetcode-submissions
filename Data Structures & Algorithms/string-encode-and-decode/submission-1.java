class Solution {
    static String delimeter = "#";

    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        sb.append(strs.size()).append(delimeter);

        for (String s : strs) {
            sb.append(s.length()).append(delimeter);
            tmp.append(s);
        }
        sb.append(tmp);
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        if (str == null || str.equals("")) {
            return ans;
        }
        
        int idx = str.indexOf(delimeter);
        int n = Integer.parseInt(str.substring(0, idx));
        int st = idx + 1;

        while (n > 0) {
            if (str.charAt(st++) == delimeter.charAt(0)) {
                n--;
            }
        }

        String[] lens = str.substring(idx + 1, st).split(delimeter);

        for (String len : lens) {
            int i = Integer.parseInt(len);
            ans.add(str.substring(st, st + i));
            st += i;
        }

        return ans;
    }
}
