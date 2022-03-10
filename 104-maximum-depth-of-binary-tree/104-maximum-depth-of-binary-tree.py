# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:    return 0
        
        def helper(root, depth):
            if not root:
                return 0
            
            return max(1 + helper(root.left, depth), 1 + helper(root.right, depth))
        
        return helper(root, 1)
    

"""
Time:  O(N)
Space: O(N) if tree is unbalanced -- each node is in one level -- recursion call will occur N times -- worst case
       O(log(N)) if tree is perfectly balanced -- best case
"""