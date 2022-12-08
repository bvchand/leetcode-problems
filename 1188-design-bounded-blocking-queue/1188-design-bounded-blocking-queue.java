class BoundedBlockingQueue {
    private int capacity;
    private List<Integer> queue = new LinkedList<>();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }
    
    public synchronized void enqueue(int element) throws InterruptedException {
        while(this.queue.size() == this.capacity)
            wait();
        if(this.queue.size() == 0)
            notifyAll();
        this.queue.add(element);
        
    }
    
    public synchronized int dequeue() throws InterruptedException {
        while(this.queue.size() == 0)
            wait();
        if(this.queue.size() == this.capacity)
            notifyAll();
        return this.queue.remove(0);
    }
    
    public synchronized int size() {
        return this.queue.size();
    }
}