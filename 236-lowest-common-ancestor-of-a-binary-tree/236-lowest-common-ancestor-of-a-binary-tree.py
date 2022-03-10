# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        nodes = (p, q)
        
        def helper(root):
            if not root:
                return (0, None)    # (number of nodes, ancestor)
            
            left_result = helper(root.left)
            if left_result[0] == 2:     return left_result
            
            
            right_result = helper(root.right)
            if right_result[0] == 2:     return right_result
            
            
            if root in nodes:
                num_nodes = 1 + left_result[0] + right_result[0]
            else:
                num_nodes = left_result[0] + right_result[0]
            
            
            return (num_nodes, root) if num_nodes == 2 else (num_nodes, None)
        
        return helper(root)[1]