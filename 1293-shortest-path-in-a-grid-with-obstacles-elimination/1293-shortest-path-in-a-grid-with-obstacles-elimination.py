"""
grid = [[0,0,0],
        [1,1,0],
        [0,0,0],
        [0,1,1],
        [0,0,0]]


grid = [[0,1,1],
        [1,1,1],
        [1,0,0]]

approach:
state <-- (r,c,k)
q <-- [steps, state]
visited <-- state
add source to q and perform bfs until q is non-empty 
    add unvisited neighbors to the q and visited set if k>=0
return True when dest is reached


time and space: m*n*k
"""

class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        
        """
        ROWS, COLS = len(grid), len(grid[0])
        source, destination = (0,0), (ROWS-1, COLS-1)
        
        if k >= ROWS + COLS - 2:
            return ROWS + COLS - 2
        
        state = (source[0],source[1],k)     # row, col, obstacles removed
        q = deque([(0, state)])   # steps, state
        visited = set([state])
                
        while q:
            steps, (r, c, k) = q.popleft()
            
            if (r,c) == destination:    return steps
            
            for nr,nc in [(r,c+1), (r,c-1), (r+1,c), (r-1,c)]:
                if 0 <= nr < ROWS and 0 <= nc < COLS:
                    new_k = k-grid[nr][nc]
                    new_state = (nr, nc, new_k)

                    if new_k >= 0 and new_state not in visited:
                        visited.add(new_state)
                        q.append((steps+1, new_state))
        return -1
        """
        ROWS, COLS = len(grid), len(grid[0])
        
        start, end = (0,0), (ROWS-1, COLS-1)
        
        if k >= ROWS+COLS-2:
            return ROWS+COLS-2
        
        state = (0,0,k)
        
        q = deque()
        q.append((0, state))
        
        visited = set()
        visited.add(state)
        
        while q:
            steps, (r,c,k) = q.popleft()
            
            if (r,c) == end:    return steps
            
            for nr, nc in [(r,c+1), (r+1,c), (r,c-1), (r-1,c)]:
                if 0 <= nr < ROWS and 0 <= nc < COLS:
                    new_k = k - grid[nr][nc]
                    new_state = (nr, nc, new_k)
                    
                    if new_k >= 0 and new_state not in visited:
                        q.append([steps+1, new_state])
                        visited.add(new_state)
            
        return -1
        
        
        
        
        
        
        
                        
                
                
        
        