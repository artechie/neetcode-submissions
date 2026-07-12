class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> gph = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                gph.putIfAbsent(ch, new HashSet<>());
                degree.putIfAbsent(ch, 0);
            }
        }

        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            int currL = curr.length();

            if (i == words.length - 1) {
                continue;
            }
            
            String next = words[i + 1];
            int nextL = next.length();

            if (curr.startsWith(next) && currL > nextL) {
                return "";
            }

            for (int j = 0; j < Math.min(currL, nextL); j++) {
                char ch = curr.charAt(j);
                char nextCh = next.charAt(j);

                if (ch != nextCh) {
                    Set<Character> set = gph.get(ch);

                    if (!set.contains(nextCh)) {
                        set.add(nextCh);
                        degree.put(nextCh, degree.getOrDefault(nextCh, 0) + 1);
                        degree.putIfAbsent(ch, 0);
                    }

                    gph.put(ch, set);

                    break;
                }
            }
        }

        // System.out.println(gph);
        System.out.println(degree);

        Deque<Character> dq = new ArrayDeque<>();

        for (char key : degree.keySet()) {
            if (degree.get(key) == 0) {
                dq.add(key);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!dq.isEmpty()) {
            char rem = dq.poll();

            sb.append(rem);

            for (char nbr : gph.get(rem)) {
                int deg = degree.get(nbr) - 1;

                degree.put(nbr, deg);

                if (deg == 0) {
                    dq.add(nbr);
                }
            }
        }

        // System.out.println(sb);

        if (degree.size() == sb.length()) {
            return sb.toString();
        }

        return "";
    }
}
