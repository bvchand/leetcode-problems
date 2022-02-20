class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        parents = [i for i in range(n)]
        rank = [1]*n
        
        def find(node):
            res = node
            
            while res != parents[res]:
                parents[res] = parents[parents[res]]
                res = parents[res]
            return res
            
        def union(n1, n2):
            p1, p2 = find(n1), find(n2)
            
            if p1 == p2:    return 0
            else:
                if rank[p1] >= rank[p2]:
                    parents[p2] = p1
                    rank[p1] += rank[p2]
                else:
                    parents[p1] = p2
                    rank[p2] += rank[p1]
            return 1
        
        count = n
        for edge in edges:
            n1, n2 = edge
            if union(n1, n2):   count -= 1
        
        return count
                    
"""
        for edge in edges:
            p, c = edge
            if parents[c] == c:
                parents[c] = parents[p]
                rank[p] += 1
                rank[c] -= 1
        
        count = 0
        for i in range(len(parents)):
            if parents[i-1] != parents[i]:
                count += 1
        print(count)
        
        return count
"""
            
            
            