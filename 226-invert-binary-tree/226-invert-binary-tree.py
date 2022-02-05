# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        
        left_node = self.invertTree(root.left)
        right_node = self.invertTree(root.right)
        
        if left_node or right_node:
            temp = left_node
            root.left = right_node
            root.right = temp
            
        return root
            