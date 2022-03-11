# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:    return []
        
        queue = deque()
        queue.append(root)
        
        res = []
        
        while queue:
            qLen = len(queue)
            level = []
            for _ in range(qLen):
                node = queue.popleft()
                if node:
                    level.append(node.val)
                    queue.append(node.left)
                    queue.append(node.right)
            if level:   res.append(level)
        
        return res
                    
                
        
        