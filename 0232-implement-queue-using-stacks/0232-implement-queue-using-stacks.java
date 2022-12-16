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
    
    public int pop() {
        transferValues(stack1, stack2);
        int res = stack2.pop();
        if(!stack2.isEmpty())
            front = stack2.peek();
        transferValues(stack2, stack1);
        
        return res;
    }
    
    public int peek() {
        return front;
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    private void transferValues(Stack<Integer> s1, Stack<Integer> s2) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
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