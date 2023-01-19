class Solution {
    
    public int longestCommonSubseq(String s, String t) {
        int m = s.length();
        int[][] dp = new int[m+1][m+1];
        
        for(int i = 0; i < m+1; i++) {
            for(int j = 0; j < m+1; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                char c1 = s.charAt(i-1), c2 = t.charAt(j-1);
                if(c1 == c2)
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                
            }
        }
        return dp[m][m];
    }
    
    
    public int longestPalindromeSubseq(String s) {
        StringBuilder t = new StringBuilder(s);
        return longestCommonSubseq(s, t.reverse().toString());
    }
}

// same as longest common subsequence