    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> words) {
            Set<String> wordList = new HashSet<>(words);

            if (!wordList.contains(endWord)) {
                return 0;
            }

            if (beginWord.equals(endWord)) {
                return 1;
            }

            int cnt = 0;
            Deque<String> dq = new ArrayDeque<>();
            dq.add(beginWord);
            Set<String> vis = new HashSet<>();
            vis.add(beginWord);

            while (!dq.isEmpty()) {
                int size = dq.size();

                cnt++;

                while (size-- > 0) {
                    String rem = dq.poll();

                    if (endWord.equals(rem)) {
                        return cnt;
                    }

                    char[] chr = rem.toCharArray();

                    for (int i = 0; i < rem.length(); i++) {
                        char orig = chr[i];

                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            chr[i] = ch;

                            String nbr = new String(chr);

                            if (wordList.contains(nbr) && vis.add(nbr)) {
                                dq.add(nbr);
                            }
                        }

                        chr[i] = orig;
                    }
                }
            }

            return 0;
        }
    }
