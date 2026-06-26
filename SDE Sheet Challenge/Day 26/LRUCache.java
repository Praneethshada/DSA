class LRUCache {
    Map<Integer, Integer> lru;
    int capacity;
    int count = 0;
    int lastKey;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lru = new LinkedHashMap<>(capacity, 0.75f, true);
    }
    
    public int get(int key) {
        if(!lru.containsKey(key)){
            return -1;
        }

        return lru.get(key);
    }
    
    public void put(int key, int value) {
        if (lru.containsKey(key)) {
            lru.put(key, value);
            return;
        }

        if (count == capacity) {
            lastKey = lru.keySet().iterator().next();
            lru.remove(lastKey);
            count--;
        }

        lru.put(key, value);
        count++;
    }
}
