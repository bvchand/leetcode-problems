# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorder_map = {data: i for i,data in enumerate(inorder)}
        
        def helper(post_start, post_end, in_start, in_end):
            if post_start >= post_end or in_start >= in_end:
                return None
            
            root_value = postorder[post_end-1]
            root = TreeNode(root_value)
            in_index = inorder_map[root_value]
            left_subtree_size = abs(in_start - in_index)
            
            root.left = helper(post_start, post_start+left_subtree_size, in_start, in_index)
            root.right = helper(post_start+left_subtree_size, post_end-1, in_index+1, in_end)
            
            return root
        
        return helper(0, len(postorder), 0, len(inorder))
            

        
        
        
        
    