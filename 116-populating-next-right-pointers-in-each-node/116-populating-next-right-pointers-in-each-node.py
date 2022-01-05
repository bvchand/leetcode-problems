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
        
        def helper(parent_node):
            while parent_node and parent_node.left:
                # print("parent_node: ", parent_node.val)
                parent_node.left.next = parent_node.right
                # print("parent_node.left.next: ", parent_node.left.next.val)
                if parent_node.next and parent_node.next.left:
                    parent_node.right.next = parent_node.next.left
                    # print("parent_node.right.next: ", parent_node.right.next.val)
                else:
                    parent_node.right.next = None
                    # print("parent_node.right.next: ", parent_node.right.next)
                
                parent_node = parent_node.next
        
        tree = root
        root.next = None
        while root and root.left:
            # print("root: ", root.val)
            helper(root)
            root = root.left
        
        return tree
                    
                    
                    
                
            