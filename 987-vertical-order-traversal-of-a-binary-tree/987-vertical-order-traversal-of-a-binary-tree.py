# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque, defaultdict

class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        colDict = defaultdict(list)
        visited = deque()
        visited.append((root, 0, 0))        # (root,row,col)
        
        min_col, max_col = 0, 0
        
        while visited:
            node, r, c = visited.popleft()
            
            if node:
                colDict[c].append((r, node.val))
                if c < min_col:     min_col = c
                elif c > max_col:   max_col = c
                visited.append((node.left, r+1, c-1))
                visited.append((node.right, r+1, c+1))
        
        res =[]
        for col in range(min_col, max_col+1):
            res.append([val for r, val in sorted(colDict[col])])
            
        return res
"""
BFS - local sorting
time: O(N.log(N/K)) --> K is the length of nodes in each col
space: O(N)
"""
        
        
        
        
        