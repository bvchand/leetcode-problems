# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
#         queue = deque()
#         depth = 0
        
#         queue.append(root)
        
#         if not root:    return depth
        
#         while queue:
#             temp_result = []
#             size = len(queue)
            
#             for i in range(size):
#                 curr_node = queue.popleft()
#                 # temp_result.append(curr_node)
                
#                 if curr_node.left:
#                     queue.append(curr_node.left)
#                 if curr_node.right:
#                     queue.append(curr_node.right)
#             depth += 1
        
#         return depth

        if not root:
            return 0
        
        left_depth = self.maxDepth(root.left)
        right_depth = self.maxDepth(root.right)
        
        return max(left_depth, right_depth) + 1
        
        
                
                
                
            
            
        
        