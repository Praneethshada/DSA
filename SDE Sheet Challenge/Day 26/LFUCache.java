class LFUCache {
    Map<Integer, Integer> vals;
    Map<Integer, Integer> cts;
    Map<Integer, LinkedHashMap<Integer, Boolean>> lists;
    int cap;
    int min = 0;

    public LFUCache(int capacity) {
        this.cap = capacity;
        vals = new HashMap<>();
        cts = new HashMap<>();
        lists = new HashMap<>();
    }

    public int get(int key) {
        if (!vals.containsKey(key)) {
            return -1;
        }

        int c = cts.get(key);
        cts.put(key, c + 1);
        lists.get(c).remove(key);

        if (c == min && lists.get(c).isEmpty()) {
            min++;
        }

        if (!lists.containsKey(c + 1)) {
            lists.put(c + 1, new LinkedHashMap<>());
        }
        lists.get(c + 1).put(key, true);

        return vals.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }

        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }

        if (vals.size() == cap) {
            int evict = lists.get(min).keySet().iterator().next();
            lists.get(min).remove(evict);
            vals.remove(evict);
            cts.remove(evict);
        }

        vals.put(key, value);
        cts.put(key, 1);
        min = 1;
        if (!lists.containsKey(1)) {
            lists.put(1, new LinkedHashMap<>());
        }
        lists.get(1).put(key, true);
    }
}
