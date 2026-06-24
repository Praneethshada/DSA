class MyQueue {

    Stack<Integer> stack;
    Stack<Integer> s;

    public MyQueue() {
        stack = new Stack<>();
        s = new Stack<>();
    }

    public void push(int x) {
        if (empty()) {
            stack.push(x);
            return;
        }

        while (!stack.isEmpty()) {
            s.push(stack.pop());
        }

        stack.push(x);

        while (!s.isEmpty()) {
            stack.push(s.pop());
        }
    }

    public int pop() {
        if (empty()) {
            return -1;
        }

        return stack.pop();
    }

    public int peek() {
        if (empty()) {
            return -1;
        }

        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}