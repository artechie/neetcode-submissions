class MinStack {
    Deque<int[]> st;

    public MinStack() {
        st = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if (!st.isEmpty()) {
            st.push(new int[]{val, Math.min(val, st.peek()[1])});
        } else {
            st.push(new int[]{val, val});
        }
    }
    
    public void pop() {
        st.poll();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}
