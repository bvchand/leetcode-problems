class ListNode:
    def __init__(self, val=0, prev=None, next=None):
        val = val
        prev = prev
        next = next
    
    
class MaxStack:
    
    def __init__(self):
        self.main_stack, self.max_stack = [], []
    
    
    def push(self, x: int) -> None:
        # print("getting here???")
        self.main_stack.append(x)
        if len(self.main_stack) == 1:  
            self.max_stack.append(x)
            return
        self.max_stack.append(max(x, self.max_stack[-1]))
            
    def pop(self) -> int:
        self.max_stack.pop()
        return self.main_stack.pop()
                                       
    def top(self) -> int:
        return self.main_stack[-1]
        
    def peekMax(self) -> int:
        return self.max_stack[-1]

    def popMax(self) -> int:
        max_val = self.max_stack[-1]
        a= []
        while self.main_stack[-1] != max_val:
            a.append(self.main_stack.pop())
            self.max_stack.pop()
        self.main_stack.pop()
        self.max_stack.pop()
        
        for val in a[::-1]:
            self.push(val)

        return max_val
        
# Your MaxStack object will be instantiated and called as such:
# obj = MaxStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.peekMax()
# param_5 = obj.popMax()