class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for(int i=0; i<m; i++) {
            if(target >= matrix[i][0] && target <= matrix[i][n-1]) {
                int left = 0, right = n;
                while(left < right) {
                    int mid = left + (right - left)/2;
                    if(matrix[i][mid] == target)
                        return true;
                    else if(matrix[i][mid] > target)
                        right = mid;
                    else
                        left = mid + 1;
                }
            }  
        }
        return false;
    }
}