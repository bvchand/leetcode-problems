# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        ans = []
        def helper(root, temp):
            if root:
                # print(root.val, temp)
                temp.append(str(root.val))
                if not root.left and not root.right:
                    ans.append("->".join(temp))
                else:
                    helper(root.left, temp)
                    helper(root.right, temp)
                temp.pop()
                
        helper(root, [])
        return ans
        