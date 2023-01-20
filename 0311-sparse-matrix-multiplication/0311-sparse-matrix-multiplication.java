class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length, k = mat1[0].length, n = mat2[0].length;
        
        int[][] res = new int[m][n];
        
        for(int row = 0; row < m; row++) {
            for(int element = 0; element < k; element++) {
                if(mat1[row][element] != 0) {
                    for(int col = 0; col < n; col++) {
                        res[row][col] += mat1[row][element] * mat2[element][col];
                    }
                    
                }
                    
            }
        }
        
        return res;
    }
}