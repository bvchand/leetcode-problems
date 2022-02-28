# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        self.sum_ = 0
        def helper(root):
            if root:
                if root.val < low:
                    helper(root.right)
                elif root.val >= low and root.val <= high:
                    self.sum_ += root.val
                    helper(root.left)
                    helper(root.right)
                elif root.val > high:
                    helper(root.left)
                
        helper(root)
        return self.sum_