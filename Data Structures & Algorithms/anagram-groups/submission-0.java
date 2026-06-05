class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String fin = new String(ch);
            map.computeIfAbsent(fin, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
