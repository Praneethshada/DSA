class myStack {
    
    ArrayList<Integer> stack;
    int n;

    public myStack(int n) {
        // Define Data Structures
        stack = new ArrayList<>();
        this.n = n;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return stack.size()==0;
    }

    public boolean isFull() {
        // check if the stack is full
        return stack.size()==n;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if(isFull()){
            return;
        }
        else{
            stack.add(x);
        }
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(isEmpty()){
            return;
        }
        else{
            stack.remove(stack.size()-1);
        }
    }

    public int peek() {
        // Returns the top element of the stack
        if(isEmpty()){
            return -1;
        }
        else{
            return stack.get(stack.size()-1);
        }
    }
}