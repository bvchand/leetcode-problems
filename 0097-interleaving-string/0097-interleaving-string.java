class Solution {
    Map<String, Boolean> dp = new HashMap<>();
    
    private boolean checkInterleave(char[] s1, char[] s2, char[] s3, int l1, int l2, int l3, int i, int j, int k) {
        String key = Integer.toString(i) + "#" + Integer.toString(j) + "#" + Integer.toString(k);
        
        // if reached the end of s3, return true
        if(k == l3)
            return i == l1 && j == l2;
        
        if(dp.containsKey(key))
            return dp.get(key);
        
        if(i == l1) {
            if(s2[j] == s3[k])
                dp.put(key, checkInterleave(s1, s2, s3, l1, l2, l3, i, j+1, k+1));
            else
                dp.put(key, false);
            
            return dp.get(key);
        }
        
        if(j == l2) {
            if(s1[i] == s3[k])
                dp.put(key, checkInterleave(s1, s2, s3, l1, l2, l3, i+1, j, k+1));
            else
                dp.put(key, false);
            
            return dp.get(key);
        }
        
        boolean isPath1Correct = false, isPath2Correct = false;
        if(s1[i] == s3[k])
            isPath1Correct = checkInterleave(s1, s2, s3, l1, l2, l3, i+1, j, k+1);
        if(s2[j] == s3[k])
            isPath2Correct = checkInterleave(s1, s2, s3, l1, l2, l3, i, j+1, k+1);
        
        dp.put(key, isPath1Correct || isPath2Correct);
        return dp.get(key);
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        int i = 0, j = 0, k = 0;
        
        if(l3 != l1 + l2)
            return false;
        
        return checkInterleave(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), l1, l2, l3, i, j, k);
    }
}