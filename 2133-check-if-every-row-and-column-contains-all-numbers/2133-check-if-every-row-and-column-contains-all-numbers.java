class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        
        for(int i=0; i<n; i++) {
            Set<Integer> rowElements = new HashSet<>();
            Set<Integer> colElements = new HashSet<>();
            for(int j=0; j<n; j++) {
                if(matrix[i][j] < 1 || matrix[i][j] > n || matrix[j][i] < 1 || matrix[j][i] > n) 
                    return false;
                rowElements.add(matrix[i][j]);
                colElements.add(matrix[j][i]);
            }
            if(rowElements.size() != n || colElements.size() != n)
                return false;
        }
        
        return true;
    }
}