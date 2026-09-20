class MinStack {
    Deque<Integer> stack;
    Deque<Integer> currMin;

    public MinStack() {
        stack = new ArrayDeque<Integer>();
        currMin = new ArrayDeque<Integer>();
    }
    
    public void push(int val) {
        stack.addFirst(val);
        if (currMin.size() == 0) {
            currMin.addFirst(val);
        } else {
            currMin.addFirst(Math.min(val, currMin.peekFirst()));
        }
    }
    
    public void pop() {
        stack.removeFirst();
        currMin.removeFirst();
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return currMin.peekFirst();
    }
}
