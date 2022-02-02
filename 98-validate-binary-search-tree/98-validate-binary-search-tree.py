# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        
        def check_valid(node, left_boundary, right_boundary):
            
            if not node:    
                return True
            
            if (left_boundary >= node.val) or  (node.val >= right_boundary):
                return False
            
            return (check_valid(node.left, left_boundary, node.val) and 
                    check_valid(node.right, node.val, right_boundary))
        
        return check_valid(root, float("-inf"), float("inf"))
                
            
        
        