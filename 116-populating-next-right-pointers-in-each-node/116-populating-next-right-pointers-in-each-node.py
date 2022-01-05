"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        
        tree = root     # copy of the root
        
        def helper(parent_node):
            while parent_node and parent_node.left:
                parent_node.left.next = parent_node.right
                if parent_node.next and parent_node.next.left:
                    parent_node.right.next = parent_node.next.left
                else:
                    parent_node.right.next = None
                
                parent_node = parent_node.next
        
        # set the next of root as None
        root.next = None 
        
        #traverse through each level
        while root and root.left:
            helper(root)
            root = root.left
        
        return tree
                    
                    
                    
                
            