class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        if (beginWord.equals(endWord)) {
            return 1;
        }

        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }

        Map<String, List<String>> map = new HashMap<>();
        int n = wordList.size();

        for (int i = 0; i < n; i++) {
            String s1 = wordList.get(i);
            for (int j = i + 1; j < n; j++) {
                String s2 = wordList.get(j);
                
                if (isValid(s1, s2)) {
                    map.computeIfAbsent(s1, k -> new ArrayList<>()).add(s2);
                    map.computeIfAbsent(s2, k -> new ArrayList<>()).add(s1);
                }
            }
        }

        int cnt = 0;

        Deque<String> dq = new ArrayDeque<>();
        dq.add(beginWord);
        Set<String> vis = new HashSet<>();

        while (!dq.isEmpty()) {
            int size = dq.size();

            cnt++;

            while (size-- > 0) {
                String rem = dq.poll();

                if (endWord.equals(rem)) {
                    return cnt;
                }

                vis.add(rem);

                for (String nbr : map.getOrDefault(rem, Collections.emptyList())) {
                    if (nbr.equals(rem) || vis.contains(nbr)) {
                        continue;
                    }

                    dq.add(nbr);
                }
            }
        }

        return 0;
    }

    private boolean isValid(String s1, String s2) {
        int diff = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }
}
