class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        visited = set()
        count = 0
        
        def dfs(r, c):
            if  r<0 or c<0 or \
                r>=ROWS or c>=COLS or \
                grid[r][c] == '0' or \
                (r,c) in visited:
                    return False
            
            visited.add((r,c))
            dfs(r+1, c)
            dfs(r-1, c)
            dfs(r, c+1)
            dfs(r, c-1)
            return True
            
        for r in range(ROWS):
            for c in range(COLS):
                if dfs(r, c):
                     count += 1
        return count
               