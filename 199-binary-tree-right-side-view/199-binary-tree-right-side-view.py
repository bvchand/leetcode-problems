# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:        
        res = []
        
        if not root:    return res
        
        q = deque()
        q.append(root)
        
        while q:
            qLen = len(q)
            res.append(q[-1].val)
            for i in range(qLen):
                node = q.popleft()
                if node.left:   q.append(node.left)
                if node.right:  q.append(node.right)
        
        print(res)
        return res
    
"""
BFS - level order traversal
time: O(N)
space: O(D)  --> D: Diameter of the binary tree
"""
        