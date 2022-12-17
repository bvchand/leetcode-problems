class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        
        int left = 0, right = (m*n)-1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            int i = mid / n, j = mid % n;
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
}

// O(m log n)

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int m = matrix.length, n = matrix[0].length;
//         for(int i=0; i<m; i++) {
//             if(target >= matrix[i][0] && target <= matrix[i][n-1]) {
//                 int left = 0, right = n-1;
//                 while(left <= right) {
//                     int mid = left + (right - left)/2;
//                     if(matrix[i][mid] == target)
//                         return true;
//                     else if(matrix[i][mid] > target)
//                         right = mid - 1;
//                     else
//                         left = mid + 1;
//                 }
//             }  
//         }
//         return false;
//     }
// }

// // O(m log n)