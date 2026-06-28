class MedianFinder {
    PriorityQueue<Integer> l, r;
    int size;

    public MedianFinder() {
        l = new PriorityQueue<>(Comparator.reverseOrder());
        r = new PriorityQueue<>();
        size = 0;
    }
    
    public void addNum(int num) {
        l.add(num);

        if (!r.isEmpty() && l.peek() > r.peek()) {
            r.add(l.poll());
        }

        if (l.size() - r.size() > 1) {
            r.add(l.poll());
        } else if (r.size() - l.size() > 1) {
            l.add(r.poll());
        }
        size++;
    }
    
    public double findMedian() {
        System.out.println(l + " " + r);
        if (size % 2 == 0) {
            return (l.peek() + r.peek()) / 2.0;
        } 
        return l.size() > r.size() ? l.peek() : r.peek();
    }
}
