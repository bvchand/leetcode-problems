class Solution:
    def shortestBridge(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        visited = set()
        flag = False
        
        # flood-fill - DFS
        def flood_fill(r, c):
            if  r<0 or r>=ROWS or c<0 or c>=COLS or grid[r][c] != 1: 
                return
            
            grid[r][c] = 2
            visited.add((r,c))
            
            flood_fill(r+1, c)
            flood_fill(r-1, c)
            flood_fill(r, c+1)
            flood_fill(r, c-1)
            
            return
        
        for i, j in product(range(ROWS), range(COLS)):
            if grid[i][j] == 1:
                flood_fill(i, j) # paint one island to 2, border 0 add to q
                break
        
        step = -1
        directions = [(1,0), (0,1), (-1,0), (0,-1)]
        queue = deque(visited)
        
        # BFS - find the minimum distance
        while queue:
            for _ in range(len(queue)):
                r,c = queue.popleft()
                for dx,dy in directions:
                    x, y = r+dx, c+dy
                    if x>=0 and x<ROWS and y>=0 and y<COLS:
                        if grid[x][y] == 1:     return step+1
                        elif grid[x][y] == 0 and (x,y) not in visited:   
                            queue.append((x,y))
                            visited.add((x,y))
            step += 1
                        
        return step
            
            
        
        
        
        
        
        
            
                
                
        