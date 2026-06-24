class myQueue {

    ArrayList<Integer> queue;
    int n;

    public myQueue(int n) {
        queue = new ArrayList<>();
        this.n = n;
    }

    public boolean isEmpty() {
        // Check if queue is empty
        return queue.size() == 0;
    }

    public boolean isFull() {
        // Check if queue is full
        return queue.size() == n;
    }

    public void enqueue(int x) {
        // Enqueue
        if (isFull()) {
            return;
        } else {
            queue.add(x);
        }
    }

    public void dequeue() {
        // Dequeue
        if (isEmpty()) {
            return;
        } else {
            queue.remove(0);
        }
    }

    public int getFront() {
        // Get front element
        if (isEmpty()) {
            return -1;
        }
        return queue.get(0);
    }

    public int getRear() {
        // Get last element
        if (isEmpty()) {
            return -1;
        }
        return queue.get(queue.size() - 1);
    }
}
