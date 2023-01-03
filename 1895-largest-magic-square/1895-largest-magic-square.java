class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        // adding an extra row and col (padding) --> so, start from 1,1
        int[][] rows = new int[m+2][n+2], 
                cols = new int[m+2][n+2], 
                d1 = new int[m+2][n+2], 
                d2 = new int[m+2][n+2];
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                rows[i][j] = grid[i-1][j-1] + rows[i][j-1];      // pick the value from original grid and add the cum sum in the prev cell
                cols[i][j] = grid[i-1][j-1] + cols[i-1][j];
                d1[i][j] = grid[i-1][j-1] + d1[i-1][j-1];
                d2[i][j] = grid[i-1][j-1] + d2[i-1][j+1];
            }
        }
        
        int res = 0;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= Math.min(m-i, n-j); k++) {     // consider every k * k possible square
                    int d1Sum = d1[i+k][j+k] - d1[i-1][j-1];
                    int d2Sum = d2[i+k][j] - d2[i-1][j+k+1];
                    boolean flag = d1Sum == d2Sum;
                    
                    // find row sum and col sum for every row and col in the k * k subgrid
                    for(int l = 0; l <= k && flag; l++) {
                        int rowSum = rows[i+l][j+k] - rows[i+l][j-1];
                        int colSum = cols[i+k][j+l] - cols[i-1][j+l];
                        if(rowSum != d1Sum || colSum != d1Sum) {
                            flag = false;
                            break;
                        }
                    }
                    // System.out.println(d1Sum + " " + d2Sum);
                    res = flag == true ? Math.max(res, k) : res;
                }
            }
        }
        return res+1;
    }
}