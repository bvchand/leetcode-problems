class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }
    
    public void push(int x) {
        if((stack1.isEmpty() && stack2.isEmpty()) || !stack1.isEmpty())
            stack1.push(x);
    }
    
    public int pop() {
        transferValues(stack1, stack2);
        int res = stack2.pop();
        transferValues(stack2, stack1);
        
        return res;
    }
    
    public int peek() {
        transferValues(stack1, stack2);
        int res = stack2.peek();
        transferValues(stack2, stack1);
        
        return res;
        
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    private void transferValues(Stack<Integer> s1, Stack<Integer> s2) {
        int n1 = s1.size();
        for(int i=0; i<n1; i++) {
            int temp = s1.pop();
            s2.push(temp);
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