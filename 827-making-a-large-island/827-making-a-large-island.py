class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        
        ROWS, COLS = len(grid), len(grid[0])
        maxSize = 0
        islandID = 2
        id2size = defaultdict(int)
        dirs = [(0,-1), (0,1), (1,0), (-1,0)]
        
        
        def getIslandSize(grid, r, c, islandID):
            if r < 0 or r >= ROWS or \
               c < 0 or c >= COLS or \
               grid[r][c] != 1:
                return 0
            grid[r][c] = islandID
            left_size = getIslandSize(grid, r, c-1, islandID)
            right_size = getIslandSize(grid, r, c+1, islandID)
            up_size = getIslandSize(grid, r-1, c, islandID)
            down_size = getIslandSize(grid, r+1, c, islandID)
            
            return left_size + right_size + up_size + down_size + 1    
                
        
        # find the size of the islands and mark with id
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1:
                    size = getIslandSize(grid, r, c, islandID)
                    id2size[islandID] = size
                    maxSize = max(size, maxSize)
                    islandID += 1
        
        
        # find the largest island
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 0:
                    neighborIslands = set()
                    for dx, dy in dirs:
                        x, y = r+dx, c+dy
                        if 0 <= x < ROWS and 0 <= y < COLS and \
                            grid[x][y] != 0:
                            neighborIslands.add(grid[x][y])     # add islandID to the set
                    
                    area = 1
                    for island in neighborIslands:
                        area += id2size[island]
                    maxSize = max(maxSize, area)
        
        return maxSize
                        
                            
"""
DFS
time: O(N^2)
space: O(N^2)
"""               
            
        
        
        
                    
                