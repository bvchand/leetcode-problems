# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.traverse_left(root)
    
    def traverse_left(self, curr):
        while curr:
            self.stack.append(curr)
            curr = curr.left
    
    def next(self) -> int:
        if self.stack:
            ans = self.stack[-1].val
        node = self.stack.pop()
        if node.right:
            self.traverse_left(node.right)
        
        return ans

    def hasNext(self) -> bool:
        return len(self.stack) > 0

    
"""
time: O(1) - average ; O(h) worse
space: O(h)
"""


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()