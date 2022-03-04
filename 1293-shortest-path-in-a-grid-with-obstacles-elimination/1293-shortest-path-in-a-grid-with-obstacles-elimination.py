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
create an adjacency list for each node (including 1s and 0s)    
q <-- steps, state
visited <-- state
add source to q and perform bfs until q is non-empty 
    add unvisited neighbors to the q and visited set if k>=0
return True when dest is reached


time and space: m*n*k
"""

class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        source, destination = (0,0), (ROWS-1, COLS-1)
        
        dirs = [(0,1), (0,-1), (1,0), (-1,0)]
        
        neighbors = defaultdict(list)
        
        # adjacency list
        for x in range(ROWS):
            for y in range(COLS):
                for dx,dy in dirs:
                    r, c = x+dx, y+dy
                    if 0 <= r < ROWS and 0 <= c < COLS:
                        neighbors[(x,y)].append((r,c))         

        
        if k >= ROWS + COLS - 2:
            return ROWS + COLS - 2
        
        state = (source[0],source[1],k)     # row, col, state
        q = deque([(0, state)])   # steps, state
        visited = set([state])
                
        while q:
            steps, (r, c, k) = q.popleft()
            
            if (r,c) == destination:    return steps
            
            # for nr,nc in [(r,c+1), (r,c-1), (r+1,c), (r-1,c)]:
                # if 0 <= nr < ROWS and 0 <= nc < COLS:
            for nr,nc in neighbors[(r,c)]:
                new_k = k-grid[nr][nc]
                new_state = (nr, nc, new_k)

                if new_k >= 0 and new_state not in visited:
                    visited.add(new_state)
                    q.append((steps+1, new_state))
        return -1

                        
                
                
        
        