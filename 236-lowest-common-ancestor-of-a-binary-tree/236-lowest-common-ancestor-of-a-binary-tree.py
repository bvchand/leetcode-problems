# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
"""
root = [            3,
           5,              1,
        6,       2,      0,    8,
               7, 4 
                
    p = 5, q = 4

root is none -> (num of nodes found = 0, ancestor = root)
l = helper(root.left)
r = helper(root.right)
if root in nodes:
    num_nodes = 1+l[0]+r[0]
else:
    num_nodes = l[0]+r[0]
return (num_nodes, root)


time=O(N)
space=O(N)


"""



class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        nodes = (p, q)
        
        def helper(root):
            if not root:
                return (0, None)        # (num_nodes, ancestor)
            
            left_result = helper(root.left)
            if left_result[0] == 2:     return left_result
            
            right_result = helper(root.right)
            if right_result[0] == 2:     return right_result
            
            if root not in nodes:
                num_nodes = left_result[0] + right_result[0]
            else:
                num_nodes = 1 + left_result[0] + right_result[0]
            
            print(root.val, num_nodes)
            return (num_nodes, root if num_nodes==2 else None)
        
        res = helper(root)
        # print(res)
        return res[1]
                
            
            