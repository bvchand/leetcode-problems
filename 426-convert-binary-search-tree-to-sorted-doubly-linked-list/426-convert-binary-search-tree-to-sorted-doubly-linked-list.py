"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""

class Solution:
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None
        
        def dfs(root):  # inorder
            if root:
                dfs(root.left)
                
                if not self.tail:    # yet to find the head
                    self.head = root
                else:
                    self.tail.right = root
                    root.left = self.tail
                self.tail = root
                
                dfs(root.right)
            return
        
        self.head = self.tail = None
        
        dfs(root)
        
        self.tail.right = self.head
        self.head.left = self.tail
        
        return self.head
        
        