class LRUCache {
    static class LRUMap<T, R> extends LinkedHashMap<T, R> {
        private int capacity;

        public LRUMap(int capacity) {
            super(capacity, .75f);
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
        Integer val = map.get(key);

        if (val == null) {
            return -1;
        }

        map.remove(key);
        map.put(key, val);

        return val;
    }
    
    public void put(int key, int value) {
        Integer val = map.get(key);

        if (val != null) {
            map.remove(key);
        }

        map.put(key, value);
    }
}
