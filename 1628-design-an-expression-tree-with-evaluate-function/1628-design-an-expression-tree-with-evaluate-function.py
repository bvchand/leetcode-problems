import abc 
from abc import ABC, abstractmethod 
"""
This is the interface for the expression tree Node.
You should not remove it, and you can define some classes to implement it.
"""

class Node(ABC):
    @abstractmethod
    def evaluate(self) -> int:
        pass
    
class TreeNode(Node):
    def __init__(self, val, left=None, right=None):
        self.value = val
        self.left = left
        self.right = right
    
    def evaluate(self) -> int:
        if self.value.isdigit():
            return int(self.value)
        elif self.value == '+':
            return self.left.evaluate() + self.right.evaluate()
        elif self.value == '*':
            return self.left.evaluate() * self.right.evaluate()
        elif self.value == '-':
            return self.left.evaluate() - self.right.evaluate()
        elif self.value == '/':
            return self.left.evaluate() // self.right.evaluate()


"""    
This is the TreeBuilder class.
You can treat it as the driver code that takes the postinfix input
and returns the expression tree represnting it as a Node.
"""

class TreeBuilder(object):
    def buildTree(self, postfix: List[str]) -> 'Node':
        curr, stack = None, []
        for char in postfix:
            curr = TreeNode(char)
            if not char.isdigit():
                curr.right = stack.pop()
                curr.left = stack.pop()
            stack.append(curr)
        return curr
                    
                
		
"""
Your TreeBuilder object will be instantiated and called as such:
obj = TreeBuilder();
expTree = obj.buildTree(postfix);
ans = expTree.evaluate();
"""
        