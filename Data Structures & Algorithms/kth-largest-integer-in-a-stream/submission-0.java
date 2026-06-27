class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.add(n);
        }
    }
    
    public int add(int val) {
        pq.add(val);

        while (!pq.isEmpty() && pq.size() > k) {
            pq.remove();
        }
        return pq.peek();
    }
}
