class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    Integer front;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        this.front = null;
    }
    
    // O(1)
    public void push(int x) {
        if(stack1.isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }
    
    // O(n)
    public int pop() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    // O(1)
    public int peek() {
        if(!stack2.isEmpty())
            return stack2.peek();
        return front;
    }
    
    // O(1)
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */