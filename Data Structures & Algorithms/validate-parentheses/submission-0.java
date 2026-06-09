class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '}' || ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char prev = stack.pop();

                if (!((ch == '}' && prev == '{') || (ch == ')' && prev == '(') || (ch == ']' && prev == '['))) {
                    return false;
                }    
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
