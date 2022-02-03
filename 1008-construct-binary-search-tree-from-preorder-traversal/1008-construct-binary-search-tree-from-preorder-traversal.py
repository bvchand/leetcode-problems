# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> Optional[TreeNode]:
        
        self.index = 0
        
        def helper(left_boundary, right_boundary):   
            
            if self.index >= len(preorder):        
                return None
            
            val = preorder[self.index]              
            
            # check for boundary condition
            if val < left_boundary or val > right_boundary:
                return None                         
            
            root = TreeNode(val)                    
            self.index += 1                         
            root.left = helper(left_boundary, val)  
            root.right = helper(val, right_boundary) 
            
            return root
        
        return helper(float("-inf"), float("inf"))
        
            
            