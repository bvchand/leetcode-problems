# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        col_dict = defaultdict(list)
        visited = deque()
        visited.append((root,0))
        
        while visited:
            # print(visited)
            node, col = visited.popleft()
            
            if node:
                col_dict[col].append(node.val)
                visited.append((node.left, col-1))
                visited.append((node.right, col+1))
        
        return [col_dict[key] for key in sorted(col_dict.keys())]
            
        