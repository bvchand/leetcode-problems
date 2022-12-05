class Solution {
    private int rows, cols;
    private int[][] image;
    private int color;
    private int srcColor;
    
    public void dfs(int r, int c) {
        if(r < 0 || r >= this.rows || c < 0 || c >= this.cols || image[r][c] != srcColor)
            return;
        
        image[r][c] = this.color;
        
        dfs(r+1, c);
        dfs(r, c+1);
        dfs(r-1, c);
        dfs(r, c-1);
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.image = image;
        this.rows = image.length;
        this.cols = image[0].length;
        this.color = color;
        this.srcColor = image[sr][sc];
        
        if(image[sr][sc] != color) {
            dfs(sr, sc);
        }
        return image;
    }
}