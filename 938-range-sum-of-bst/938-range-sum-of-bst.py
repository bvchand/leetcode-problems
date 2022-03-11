# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        
             
        def helper(root):
            if root:
                if root.val >= low and root.val <= high:
                    self.ans += root.val
                if root.val > low:
                    helper(root.left)
                if root.val < high:
                    helper(root.right)
        self.ans = 0
        helper(root)
        return self.ans
        