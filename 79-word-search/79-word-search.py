class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        ROWS, COLS = len(board), len(board[0])   
        visited = set()
        
        def dfs(r, c, i):
            if i == len(word):      # reached end of string
                return True
            
            if (r<0 or c<0 or               # check for boundary condtions and if the letter is present in the current matrix index
                r>=ROWS or c>=COLS or
                word[i] != board[r][c] or
                (r,c) in visited):
                return False
            
            visited.add((r,c))
            res =   (dfs(r+1, c, i+1) or 
                     dfs(r-1, c, i+1) or 
                     dfs(r, c+1, i+1) or 
                     dfs(r, c-1, i+1))
            visited.remove((r,c))
            return res
            
        
        for r in range(ROWS):
            for c in range(COLS):
                # call the recursive function
                if dfs(r, c, 0):
                    return True
        return False
        
        