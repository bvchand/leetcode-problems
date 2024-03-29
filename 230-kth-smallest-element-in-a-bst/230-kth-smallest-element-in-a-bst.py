# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
   
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        """
            inorder = []
            def helper(root):
                if not root:    return

                helper(root.left)
                inorder.append(root.val)
                helper(root.right)

            helper(root)
            return inorder[k-1]
        """
        inord = []
        def inorder(root):
            if not root:    return
            
            inorder(root.left)
            inord.append(root.val)
            inorder(root.right)
            return
        inorder(root)
        return inord[k-1]
            
            
        
    
    