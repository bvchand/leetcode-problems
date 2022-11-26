class Solution {
    private int[][] grid;
    private final int WATER = 0, LAND = 1;
    private int ROWS, COLS;
    private int maxArea;
    
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.ROWS = grid.length;
        this.COLS = grid[0].length;
        
        this.maxArea = 0;
        
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == LAND) {
                    int area = dfsHelper(r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    
    public int dfsHelper(int r, int c) {
        if (r < 0 || r >= ROWS ||  c < 0 || c >= COLS || grid[r][c] != LAND)
            return 0;
        
        grid[r][c] = 2;
        
        int bottom = dfsHelper(r+1, c);
        int right = dfsHelper(r, c+1);
        int top = dfsHelper(r-1, c);
        int left = dfsHelper(r, c-1);
        
        return 1 + bottom + right + top + left;
    }
}