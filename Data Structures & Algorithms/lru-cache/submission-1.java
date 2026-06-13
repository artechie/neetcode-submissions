    class LRUCache {
        static class Node {
            int key;
            int val;
            Node next;
            Node prev;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }
        private final Map<Integer, Node> map;
        private final Node dummyHead;
        private final Node dummyTail;
        private int size;
        private final int CAPACITY;

        private void addFirst(Node n) {
            n.next = dummyHead.next;
            n.next.prev = n;
            n.prev = dummyHead;
            dummyHead.next = n;
            size++;
        }

        private void remove(Node n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            size--;
        }

        public LRUCache(int capacity) {
            map = new HashMap<>();
            dummyHead = new Node(-1, -1);
            dummyTail = new Node(-1 ,-1);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
            this.CAPACITY = capacity;
            size = 0;
        }
        
        public int get(int key) {
            Node n = map.get(key);

            if (n == null) {
                return -1;
            }

            remove(n);
            addFirst(n);

            return n.val;
        }
        
        public void put(int key, int value) {
            Node n = map.computeIfAbsent(key, k -> new Node(key, value));

            if (n.prev != null) {
                remove(n);
                n.val = value;
            }

            addFirst(n);

            if (size > CAPACITY) {
                int k = dummyTail.prev.key;
                remove(dummyTail.prev);
                map.remove(k);
            }   
        }
    }
