class TimeMap {
    static class Pair implements Comparable<Pair> {
        int time;
        String value;

        public Pair(int time, String value) {
            this.time = time;
            this.value = value;
        }

        public int compareTo(Pair other) {
            return Integer.compare(this.time, other.time);
        }
    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> pairs = map.get(key);

        if (pairs == null || pairs.isEmpty()) {
            return "";
        }

        int l = 0, r = pairs.size() - 1;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;

            if (timestamp < pairs.get(mid).time) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        Pair found = pairs.get(l);

        return found.time <= timestamp ? found.value : ""; 
    }
}
