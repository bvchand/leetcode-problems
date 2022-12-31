class Solution {
    int[][] grid;
    int rows, cols;
    final int OBSTACLE = 1, EMPTY = 0;
    Map<String, Integer> seen = new HashMap<>();    // memoizing the path that could potentially lead to the goal
    
    
    public int dfs(int r, int c) {
        if(r < 0 || r >= rows || c < 0 || c >= cols) {
            return 0;
        }
        
        String key = String.valueOf(r) + "," + String.valueOf(c);
        // System.out.println(key);
        
        if(seen.containsKey(key))
            return seen.get(key);
  
        if(r == rows-1 && c == cols-1) {
            if(grid[r][c] == OBSTACLE)  return 0;
            return 1;
        }
        
        if(grid[r][c] == OBSTACLE) {
            seen.put(key, 0);
            return 0;
        }
                
        int down = dfs(r+1, c);
        int right = dfs(r, c+1);
        
        seen.put(key, down + right);
        return seen.get(key);
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.grid = obstacleGrid;
        this.rows = obstacleGrid.length;
        this.cols = obstacleGrid[0].length;
        
        return dfs(0, 0);
    }
}