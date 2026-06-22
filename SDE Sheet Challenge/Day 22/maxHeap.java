class maxHeap {

    ArrayList<Integer> heap;

    public maxHeap() {
        // Initialize your data members
        heap = new ArrayList<>();
    }

    public void push(int x) {
        // Insert x into the heap
        int idx = heap.size();
        heap.add(x);
        while (idx > 0 && heap.get((idx - 1) / 2) < x) {
            Collections.swap(heap, (idx - 1) / 2, idx);
            idx = (idx - 1) / 2;
        }
        return;
    }

    public void pop() {
        // Remove the top (maximum) element
        if (heap.isEmpty()) {
            return;
        }

        int n = heap.size();
        Collections.swap(heap, 0, n - 1);
        heap.remove(n - 1);

        int idx = 0;
        n = heap.size();

        while (2 * idx + 1 < n) {
            int lc = 2 * idx + 1;
            int rc = 2 * idx + 2;
            int large = lc;

            if (rc < n && heap.get(rc) > heap.get(lc)) {
                large = rc;
            }

            if (heap.get(idx) < heap.get(large)) {
                Collections.swap(heap, idx, large);
                idx = large;
            } else {
                break;
            }
        }

    }

    public int peek() {
        // Return the top element or -1 if empty
        if (heap.isEmpty()) {
            return -1;
        }
        return heap.get(0);
    }

    public int size() {
        // Return the number of elements in the heap
        return heap.size();
    }
}