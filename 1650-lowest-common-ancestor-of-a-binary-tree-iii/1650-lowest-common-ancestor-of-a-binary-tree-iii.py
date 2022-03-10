"""
# Definition for a Node.
class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None
"""
"""
class Solution:
    def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
        parents = set()
        
        while p:
            parents.add(p)
            p = p.parent
            
        while q:
            if q in parents:    return q
            q = q.parent
        
        return None


time: O(N)
space: O(N)
"""

"""
Similar to intersection of 2 linked lists

time: O(N)
space: O(1)
"""
class Solution:
    def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
        a, b = p, q
        
        while a != b:
            a = a.parent if a else q
            b = b.parent if b else p
            print(a, b)
        return a
        
        
        
                