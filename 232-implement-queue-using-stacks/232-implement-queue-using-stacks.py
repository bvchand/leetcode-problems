class MyQueue:

    def __init__(self):
        self.stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        temp = []
        for i in range(1, len(self.stack)):
            temp.append(self.stack.pop())
            print(temp)
        
        popped_val = self.stack.pop()
        self.stack = temp[::-1]
        return popped_val

    def peek(self) -> int:
        if len(self.stack)>0:   
            return self.stack[0]

    def empty(self) -> bool:
        return len(self.stack) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()