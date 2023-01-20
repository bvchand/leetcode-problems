class Solution {
    public int minDistance(String A, String B) {
        int m = A.length(), n = B.length();
        int commonSeq = longestCommonSubseq(A, B, m, n);
        
        return m + n - (2 * commonSeq);
    }
    
    private int longestCommonSubseq(String A, String B, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++) {
            for(int j = 0; j < n+1; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                char a = A.charAt(i-1), b = B.charAt(j-1);
                if(a == b)
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[m][n];
    }
}