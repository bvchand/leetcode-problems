class Solution {
    public void countNumIslandsDFS(char[][] grid, int rows, int cols, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1') {
            return;
        }
        
        grid[r][c] = '2';
        
        countNumIslandsDFS(grid, rows, cols, r+1, c);
        countNumIslandsDFS(grid, rows, cols, r, c+1);
        countNumIslandsDFS(grid, rows, cols, r, c-1);
        countNumIslandsDFS(grid, rows, cols, r-1, c);
    }
    
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        int rows = grid.length, cols = grid[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    numberOfIslands++;
                    countNumIslandsDFS(grid, rows, cols, r, c);
                }
            }
        }
        return numberOfIslands;
    }
}