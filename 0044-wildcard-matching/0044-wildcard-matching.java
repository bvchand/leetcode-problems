class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        
        if(s.equals(p))
            return true;
        
        // only * chars in pattern
        if(pLen > 0 && p.chars().allMatch(c -> c == '*'))
            return true;
        
        // if either one is empty and the other one is not --> false
        if(p.isEmpty() || s.isEmpty())
            return false;
        
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        
        // 1. s[0] == ""; p[0] == "" --> since empty string matches empty pattern
        dp[0][0] = true;
        
        // 2. dp[i][0] = false; since empty pattern cannot be equal to a non-empty string (first col)
        
        // 3. dp[0][j] (first row)
        // for any continuative '*' will match empty string
        // e.g s='aasffdasda' p='*'/'**'/'***'....
        for(int j = 1; j < pLen; j++) {
            if(p.charAt(j-1) == '*')
                dp[0][j] = dp[0][j-1];
        }        
        
        
        // 1. if p.charAt(j) == s.charAt(i), match single character
        // =>>> dp[i][j] = dp[i - 1][j - 1]
        
        // 2. if p.charAt(j) == '?', '?' match single character
        // =>>> dp[i][j] = dp[i - 1][j - 1]

        // 3. if p.charAt(j) == '*', dp[i][j]=dp[i-1][j]||dp[i][j-1]
        // =>>> a. '*' match empty: dp[i][j]=dp[i-1][j]
        // =>>> b. '*' match multiple characters: dp[i][j]=dp[i][j-1]
        
        
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

/*
DP bottom-up approach
time = O(sLen * pLen)
space = O(sLen * pLen)
*/