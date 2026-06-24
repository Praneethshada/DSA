class MyStack {

    Queue<Integer> queue;
    Queue<Integer> q;

    public MyStack() {
        queue = new LinkedList<>();
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        while (!queue.isEmpty()) {
            q.add(queue.remove());
        }
        Queue<Integer> temp = q;
        q = queue;
        queue = temp;
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        return queue.remove();
    }

    public int top() {
        if (empty()) {
            return -1;
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}