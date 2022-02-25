# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# BFS 
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        col_dict = defaultdict(list)
        visited = deque()
        visited.append((root,0))
        min_col, max_col = sys.maxsize, 0
        
        while visited:
            node, col = visited.popleft()
            
            if node:
                col_dict[col].append(node.val)
                if col < min_col:   min_col = col
                elif col > max_col: max_col = col
                visited.append((node.left, col-1))
                visited.append((node.right, col+1))
        
        return [col_dict[i] for i in range(min_col, max_col+1)]
            
        