/*
DFS
- first find the pattern of an island
- create a string of the pattern
- add the string to a hashset to keep track of the number of islands

space = O(number of distinct islands)
time = O(ROWSxCOLS)
*/

class Solution {
    final int WATER = 0, LAND = 1;
    int baseRow, baseCol;
    int[][] grid;
    int ROWS, COLS;
    
    public void dfs (int r, int c, StringBuilder sb) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] == WATER) {
            return;
        }
        
        sb.append(r - baseRow);
        sb.append(',');
        sb.append(c - baseCol);
        sb.append('|');
        
        grid[r][c] = WATER;
        
        dfs(r+1, c, sb);
        dfs(r, c+1, sb);
        dfs(r-1, c, sb);
        dfs(r, c-1, sb);
    }
    
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        ROWS = grid.length;
        COLS = grid[0].length;
        
        HashSet<String> distinctIslands = new HashSet<String>();
        
        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
                if (grid[r][c] == LAND) {
                    baseRow = r;
                    baseCol = c;
                    StringBuilder sb = new StringBuilder();
                    dfs(r, c, sb);
                    distinctIslands.add(sb.toString());
                }
            }
        }
        return distinctIslands.size();
    }
}