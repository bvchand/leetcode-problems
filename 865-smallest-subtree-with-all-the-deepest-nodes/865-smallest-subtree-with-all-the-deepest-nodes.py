# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def subtreeWithAllDeepest(self, root: TreeNode) -> TreeNode:
        
        def dfs(root, parent=None):
            if root:
                depth[root] = depth[parent] + 1
                dfs(root.left, root)
                dfs(root.right, root)
                
        def get_deepest_subtree(root):
            if not root or depth[root] == max_depth:
                return root
            L = get_deepest_subtree(root.left)
            R = get_deepest_subtree(root.right)
            
            return root if (L and R) else (L or R)
        
        
        depth = {None:-1,}
        dfs(root)
        max_depth = max(depth.values())
        return get_deepest_subtree(root)