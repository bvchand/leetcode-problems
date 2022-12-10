class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        
        if(s.equals(p))
            return true;
        
        // only * chars in pattern
        if(pLen > 0 && p.chars().allMatch(c -> c == '*'))
            return true;
        
        if(p.isEmpty() || s.isEmpty())
            return false;
        
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        
        for(int j = 1; j < pLen; j++) {
            if(p.charAt(j-1) == '*')
                dp[0][j] = dp[0][j-1];
        }
        
        
        for(int i = 1; i <= sLen; i++) {
            for(int j = 1; j <= pLen; j++) {
                char charS = s.charAt(i-1), charP = p.charAt(j-1);
                if(charS == charP || charP == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(charP == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
        }
        return dp[sLen][pLen];
    }
}