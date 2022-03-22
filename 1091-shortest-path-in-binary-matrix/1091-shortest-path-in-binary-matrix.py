class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        start, end = (0,0), (ROWS-1, COLS-1)
        dirs = [(0,1), (0,-1), (1,0), (-1,0), (1,1), (1,-1), (-1,1), (-1,-1),]
        visited = set()
        q = deque()
        
        if grid[0][0] == 0:
            q.append((1, (0,0)))          # (steps, (r,c)) <-- state
            visited.add((0,0))
        
        while q:
            steps, (r, c) = q.popleft()
            
            if (r,c) == end:
                return steps
            
            for dx, dy in dirs:
                x, y = r+dx, c+dy
                if 0 <= x < ROWS and 0 <= y < COLS and grid[x][y] == 0 and (x,y) not in visited:
                    visited.add((x,y))
                    q.append((steps+1, (x,y)))
        
        return -1
        
                    
                    
                
        
        
        
        