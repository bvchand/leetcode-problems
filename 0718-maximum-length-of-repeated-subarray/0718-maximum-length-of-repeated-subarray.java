class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int rows = nums1.length, cols = nums2.length;
        int[][] dp = new int[rows+1][cols+1];
        int maxLength = 0;
        // int maxRow = 0, maxCol = 0;
        
        // fill the dp table based on the numrs
        for(int r = 0; r <= rows; r++) {
            for(int c = 0; c <= cols; c++) {
                if (r == 0 || c == 0) {
                    dp[r][c] = 0;
                    continue;
                }
                int n1 = nums1[r-1], n2 = nums2[c-1];
                if(n1 == n2) {
                    dp[r][c] = 1 + dp[r-1][c-1];
                    if(maxLength <= dp[r][c]) {
                        maxLength = dp[r][c];
                        // maxRow = r; 
                        // maxCol = c;
                    }
                } else {
                    dp[r][c] = 0;
                }
                
            }
        }
        
        // retrieve the subarray based on maxRow and maxCol
        // int[] result = new int[maxLength];
        // if(maxLength != 0) {
        //     int i = 0;
        //     while(dp[maxRow][maxCol] > 0) {
        //         result[i] = nums1[maxRow-1];
        //         System.out.println(result[i]);
        //         i++; maxRow--; maxCol--;
        //     }
        // }
        
        return maxLength;
    }
}