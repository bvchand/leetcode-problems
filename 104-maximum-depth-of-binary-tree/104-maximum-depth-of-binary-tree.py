# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        return max(1 + self.maxDepth(root.left), 1 + self.maxDepth(root.right))    

"""
Time:  O(N)
Space: O(N) if tree is unbalanced -- each node is in one level -- recursion call will occur N times -- worst case
       O(log(N)) if tree is perfectly balanced -- best case
"""