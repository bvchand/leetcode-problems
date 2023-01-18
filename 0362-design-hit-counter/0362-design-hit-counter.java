class HitCounter {
    
    Queue<Integer> hits;

    
    public HitCounter() {
        hits = new LinkedList<>();
        
    }
    
    public void hit(int timestamp) {
        this.hits.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!this.hits.isEmpty()) {
            int diff = timestamp - this.hits.peek();
            if(diff >= 300)
                this.hits.remove();
            else
                break;
        }
        return this.hits.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */