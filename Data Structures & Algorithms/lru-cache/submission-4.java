class LRUCache {
    static class LRUMap<T, R> extends LinkedHashMap<T, R> {
        private int capacity;

        public LRUMap(int capacity) {
            super(capacity, .75f, true);
            this.capacity = capacity;
        }

        @Override
        public boolean removeEldestEntry(Map.Entry<T, R> entry) {
            return this.size() > capacity;
        }
    }

    LRUMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LRUMap(capacity);
    }
    
    public int get(int key) {
        return map.get(key) == null ? -1 : map.get(key);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}
