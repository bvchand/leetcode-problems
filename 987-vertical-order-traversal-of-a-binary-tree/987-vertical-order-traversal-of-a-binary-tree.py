# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque, OrderedDict

class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        nodes = []
        visited = deque()
        visited.append((root, 0, 0))        # (root,row,col)
        
        while visited:
            node, r, c = visited.popleft()
            
            if node:
                nodes.append([c, r, node.val])
                visited.append((node.left, r+1, c-1))
                visited.append((node.right, r+1, c+1))
            
        nodes.sort()        # sorts first by col, row, root.val
        
        colMap = OrderedDict()
        
        for c, r, val in nodes:
            if c in colMap:
                colMap[c].append(val)
            else:
                colMap[c] = [val]
        
        return [vals for vals in colMap.values()]
        
        
        
        
        