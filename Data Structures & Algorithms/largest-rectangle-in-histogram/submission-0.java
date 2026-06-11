class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> rightSmaller = new ArrayDeque<>();
        Deque<Integer> leftSmaller = new ArrayDeque<>();
        int[] rs = new int[n];
        int max = 0;

        for (int i = n - 1; i >= 0; i--) {
            while (!rightSmaller.isEmpty() && heights[rightSmaller.peek()] >= heights[i]) {
                rightSmaller.poll();
            }

            rs[i] = rightSmaller.isEmpty() ? n : rightSmaller.peek();

            rightSmaller.push(i);
        }

        for (int i = 0; i < n; i++) {
            while (!leftSmaller.isEmpty() && heights[leftSmaller.peek()] >= heights[i]) {
                leftSmaller.poll();
            }

            int ls = leftSmaller.isEmpty() ? -1 : leftSmaller.peek();

            leftSmaller.push(i);

            max = Math.max(max, heights[i] * (rs[i] - ls - 1));   
        }
        return max;
    }
}
