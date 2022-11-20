class LRUCache {
    
    // Doubly linked list to manage the LRU Cache
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }
    
    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }
    
    private DLinkedNode popTail() {
        DLinkedNode poppedNode = tail.prev;
        removeNode(poppedNode);
        return poppedNode;
    }
    
    
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size, capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        head = new DLinkedNode();
        tail = new DLinkedNode();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            
            cache.put(key, newNode);
            addNode(newNode);
            
            size++;
            if (size > capacity) {
                DLinkedNode poppedNode = popTail();
                cache.remove(poppedNode.key);
                size--;
                
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


/**
1. use doubly linked list
2. whenever a node added -- add it to the head
3. whenever a node is accessed -- move it to the head
4. whenever the size exceeds capacity -- pop the tail
*/