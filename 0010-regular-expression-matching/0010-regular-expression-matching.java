class Solution {
    public Map<List<Integer>, Boolean> memo;
    public String string;
    public String pattern;
    public int sLen, pLen;
    
    public boolean dfs(int i, int j) {
        List<Integer> currIndex = Arrays.asList(i,j);
        
        if(memo.containsKey(currIndex))
            return memo.get(currIndex);
        
        if(i >= sLen && j >= pLen)
            return true;
        if(j >= pLen)
            return false;
        
        boolean ans;
        
        boolean charMatch = (i < sLen) && (string.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
        
        if((j+1 < pLen) && (pattern.charAt(j+1) == '*'))
            ans = dfs(i, j+2) || (charMatch && dfs(i+1, j));
        else
            ans = charMatch && dfs(i+1, j+1);
        
        memo.put(currIndex, ans);
        return ans;
    }
    
    public boolean isMatch(String s, String p) {
        sLen = s.length();
        pLen = p.length();
        string = s;
        pattern = p;
        
        memo = new HashMap<>();
        return dfs(0, 0);
    }
}