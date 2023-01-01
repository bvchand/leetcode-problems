class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0] == 1)
            return 0;
        
        obstacleGrid[0][0] = 1;
        
        // fill the first row
        for(int i = 1; i < cols; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1) ? 1 : 0;
        }
        
        // fill the first col
        for(int i = 1; i < rows; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1) ? 1 : 0;
        }
        
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(obstacleGrid[i][j] == 0)
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                else
                    obstacleGrid[i][j] = 0;
            }
        }
        
        return obstacleGrid[rows-1][cols-1];
    }
}

// time: O(M*N)

// class Solution {
//     int[][] grid;
//     int rows, cols;
//     final int OBSTACLE = 1, EMPTY = 0;
//     Map<String, Integer> seen = new HashMap<>();    // memoizing the path that could potentially lead to the goal
    
    
//     public int dfs(int r, int c) {
//         if(r < 0 || r >= rows || c < 0 || c >= cols) {
//             return 0;
//         }
        
//         String key = String.valueOf(r) + "," + String.valueOf(c);
//         // System.out.println(key);
        
//         if(seen.containsKey(key))
//             return seen.get(key);
  
//         if(r == rows-1 && c == cols-1 && grid[r][c] != OBSTACLE) {
//             return 1;
//         }
        
//         if(grid[r][c] == OBSTACLE) {
//             seen.put(key, 0);
//             return 0;
//         }
                
//         int down = dfs(r+1, c);
//         int right = dfs(r, c+1);
        
//         seen.put(key, down + right);
//         return seen.get(key);
//     }
    
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         this.grid = obstacleGrid;
//         this.rows = obstacleGrid.length;
//         this.cols = obstacleGrid[0].length;
        
//         return dfs(0, 0);
//     }
// }

// time and space: O(M*N)