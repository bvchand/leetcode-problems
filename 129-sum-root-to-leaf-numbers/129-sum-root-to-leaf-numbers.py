# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # my implementation
#     def sumNumbers(self, root: Optional[TreeNode]) -> int:
#         self.sum_ = 0
#         self.temp = ''
                
#         def helper(root):
#             self.temp += str(root.val)
#             if not root.left and not root.right:
#                 self.sum_ += int(self.temp)
#                 return
#             if root.left:
#                 helper(root.left)
#                 self.temp = self.temp[:-1]
#             if root.right:
#                 helper(root.right)
#                 self.temp = self.temp[:-1]

#         helper(root)
#         return self.sum_
    
    # preorder
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.sum_ = 0
                
        def preorder(root, temp):
            if not root: return
            
            temp = temp * 10 + root.val
            if not root.left and not root.right:
                self.sum_ += temp
                return
            else:
                preorder(root.left, temp)
                preorder(root.right, temp)

        preorder(root, 0)
        return self.sum_
        