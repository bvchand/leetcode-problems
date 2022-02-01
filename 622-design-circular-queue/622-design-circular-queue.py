class Node:
    def __init__(self, x, next=None):
        self.val = int(x)
        self.next = next
        
class SLL:
    def __init__(self):
        self.head = Node(0)
        self.tail = self.head
    
    def insert(self, x):
        temp = self.tail
        self.tail.next = Node(x)
        self.tail = self.tail.next
    
    def remove(self, head):
        removed_node = head.next
        head.next = head.next.next
        if self.tail == removed_node:   self.tail = self.head
        removed_node = None

class MyCircularQueue:

    def __init__(self, k: int):
        self.q = SLL()
        self.size = 0
        self.capacity = k
        
    def enQueue(self, value: int) -> bool:
        if self.size < self.capacity:
            self.q.insert(value)
            self.size += 1
            return True
        return False
        
    def deQueue(self) -> bool:
        if self.size > 0:
            node = self.q.head
            self.q.remove(node)
            self.size -= 1
            return True
        return False
            
    def Front(self) -> int:
        if self.size > 0 :   
            return self.q.head.next.val
        return -1

    def Rear(self) -> int:
        if self.size > 0 :   
            return self.q.tail.val
        return -1

    def isEmpty(self) -> bool:
        return self.size == 0

    def isFull(self) -> bool:
        return self.size == self.capacity


# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()