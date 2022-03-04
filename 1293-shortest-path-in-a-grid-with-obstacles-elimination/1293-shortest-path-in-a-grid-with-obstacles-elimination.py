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

# class Solution:
#     def shortestPath(self, grid: List[List[int]], k: int) -> int:
#         ROWS, COLS = len(grid), len(grid[0])
#         source, destination = (0,0), (ROWS-1, COLS-1)
        
#         """
#         dirs = [(0,1), (0,-1), (1,0), (-1,0)]
        
#         neighbors = defaultdict(list)
        
#         # adjacency list
#         for x in range(ROWS):
#             for y in range(COLS):
#                 for dx,dy in dirs:
#                     r, c = x+dx, y+dy
#                     if 0 <= r < ROWS and 0 <= c < COLS:
#                         neighbors[(x,y)].append((r,c))         
#         """
        
#         state = (source[0],source[1],k)     # row, col, state
#         q = deque([(0, state)])   # steps, state
#         visited = set([state])
                
#         while q:
#             steps, (r, c, k) = q.popleft()
            
#             if (r,c) == destination:    return steps
            
#             for nr,nc in [(r,c+1), (r,c-1), (r+1,c), (r-1,c)]:
#                 if 0 <= nr < ROWS and 0 <= nc < COLS:
#                     new_k = k-grid[nr][nc]
#                     new_state = (nr, nc, new_k)

#                     if new_k >= 0 and (nr, nc) not in visited:
#                         visited.add(new_state)
#                         q.append((steps+1, new_state))
#         return -1


class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        rows, cols = len(grid), len(grid[0])
        target = (rows - 1, cols - 1)

        # if we have sufficient quotas to eliminate the obstacles in the worst case,
        # then the shortest distance is the Manhattan distance
        if k >= rows + cols - 2:
            return rows + cols - 2

        # (row, col, remaining quota to eliminate obstacles)
        state = (0, 0, k)
        # (steps, state)
        queue = deque([(0, state)])
        seen = set([state])

        while queue:
            steps, (row, col, k) = queue.popleft()

            # we reach the target here
            if (row, col) == target:
                return steps

            # explore the four directions in the next step
            for new_row, new_col in [(row, col + 1), (row + 1, col), (row, col - 1), (row - 1, col)]:
                # if (new_row, new_col) is within the grid boundaries
                if (0 <= new_row < rows) and (0 <= new_col < cols):
                    new_eliminations = k - grid[new_row][new_col]
                    new_state = (new_row, new_col, new_eliminations)
                    # add the next move in the queue if it qualifies
                    if new_eliminations >= 0 and new_state not in seen:
                        seen.add(new_state)
                        queue.append((steps + 1, new_state))

        # did not reach the target
        return -1

                        
                
                
        
        