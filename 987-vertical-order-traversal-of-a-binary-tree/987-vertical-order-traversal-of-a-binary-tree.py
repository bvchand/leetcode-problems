# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        cols = []
        visited = deque([(root,0,0)])
        min_col, max_col = sys.maxsize, 0
        
        while visited:
            node, row, col = visited.popleft()
            
            if node:
                cols.append((col, row, node.val))
                # if col < min_col:   min_col = col
                # elif col > max_col: max_col = col
                visited.append((node.left, row+1, col-1))
                visited.append((node.right, row+1, col+1))
        
        cols.sort()
        ret = OrderedDict()
        for column, row, value in cols:
            if column in ret:
                ret[column].append(value)
            else:
                ret[column] = [value]

        return ret.values()
        
        