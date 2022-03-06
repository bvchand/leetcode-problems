"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':   # BFS
        if not node:
            return node
        
        visited = {}
        queue = deque([node])
        visited[node] = Node(node.val, [])
        
        while queue:
            n = queue.popleft()
                        
            for neigh in n.neighbors:
                if neigh not in visited:
                    visited[neigh] = Node(neigh.val, [])
                    queue.append(neigh)
                visited[n].neighbors.append(visited[neigh])
        return visited[node]
        
        
        