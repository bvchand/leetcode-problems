class Solution {
    StringBuilder sb = new StringBuilder();
    List<String> result = new ArrayList<>();
    int n;
    
    private void backtrack(int nOpen, int nClosed) {
        if(nOpen == n && nClosed == n) {
            result.add(sb.toString());
            // System.out.println();
            return;
        }
        // System.out.println(sb.toString());
        if(nOpen < n) {
            sb.append("(");
            backtrack(nOpen + 1, nClosed);
            sb.deleteCharAt(sb.length() -1);
        }
        
        if(nClosed < nOpen) {
            sb.append(")");
            backtrack(nOpen, nClosed + 1);
            sb.deleteCharAt(sb.length() -1);
        }
            
    }
    
    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtrack(0, 0);    //# of open parantheses and # of closed paratheses
        return result;
    }
}

// backtracting (dfs)