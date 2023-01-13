class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    int target;
    
    private void dfs(int idx, List<Integer> currCombo, int currTotal) {
        if(target == currTotal) {
            res.add(new ArrayList<>(currCombo));
            return;
        }
            
        
        if(idx >= candidates.length || currTotal > target)
            return;
        
        currCombo.add(candidates[idx]);
        dfs(idx, currCombo, currTotal + candidates[idx]);
        currCombo.remove(currCombo.size()-1);
        
        dfs(idx+1, currCombo, currTotal);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        
        dfs(0, new ArrayList<Integer>(), 0);
        return res;
    }
}