class Node:
    def __init__(self, x, next=None, prev=None):
        self.val = int(x)
        self.next = next
        
class SLL:
    def __init__(self):
        self.dummyhead = Node(0)
        self.rear = self.dummyhead
        # self.rear.next = self.dummyhead
    
    def insert(self, x):
        temp = self.rear
        self.rear.next = Node(x)
        self.rear = self.rear.next
    
    def remove(self, head):
        removed_node = head.next
        head.next = head.next.next
        if self.rear == removed_node:   self.rear = self.dummyhead
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
            node = self.q.dummyhead
            self.q.remove(node)
            self.size -= 1
            return True
        return False
            
    def Front(self) -> int:
        if self.size > 0 :   
            return self.q.dummyhead.next.val
        return -1

    def Rear(self) -> int:
        if self.size > 0 :   
            return self.q.rear.val
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