# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        inorder_index = {data: i for i, data in enumerate(inorder)}

        def preorder_inorder_helper(pre_start, pre_end, in_start, in_end):
            if pre_start >= pre_end or in_start >= in_end:
                return None

            root_value = preorder[pre_start]
            root = TreeNode(root_value)
            index = inorder_index[root_value]
            subtree_size = abs(in_start - index)

            root.left = preorder_inorder_helper(pre_start+1, pre_start+subtree_size+1,
                                                in_start, index)
            root.right = preorder_inorder_helper(pre_start+subtree_size+1, pre_end,
                                                 index+1, in_end)

            return root

        return preorder_inorder_helper(0, len(preorder), 0, len(inorder))
      
        