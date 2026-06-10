class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> st = new ArrayDeque<>();

        for (String t : tokens) {
            if (!(t.equals("+") || t.equals("-") || t.equals("/") || t.equals("*"))) {
                st.push(t);
            } else {
                char ch = t.charAt(0);

                int y = Integer.parseInt(st.pop());
                int x = Integer.parseInt(st.pop());

                if (ch == '*') {
                    st.push(x * y + "");
                } else if (ch == '/') {
                    st.push(x / y + "");
                } else if (ch == '+') {
                    st.push(x + y + "");
                } else {
                    st.push(x - y + "");
                }
            }
        }
        return Integer.parseInt(st.pop());
    }
}
