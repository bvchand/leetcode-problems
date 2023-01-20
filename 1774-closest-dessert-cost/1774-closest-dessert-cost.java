class Solution {
    private int closestDiff = Integer.MAX_VALUE, closestCost = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for(int base: baseCosts) {
            dfs(base, 0, toppingCosts, target);
        }
        return closestCost;
    }
    
    private void dfs(int currCost, int toppingIdx, int[] toppingCosts, int target) {
        int currDiff = Math.abs(target - currCost);
        if((currDiff == closestDiff && currCost < closestCost) || currDiff < closestDiff) {
            closestDiff = currDiff;
            closestCost = currCost;
        }
        
        // exit condition
        if(toppingIdx >= toppingCosts.length || currCost > target)
            return;
        
        dfs(currCost, toppingIdx + 1, toppingCosts, target);                                    // 0 count of curr topping
        dfs(currCost + toppingCosts[toppingIdx], toppingIdx + 1, toppingCosts, target);       // 1 count of curr topping
        dfs(currCost + 2 * toppingCosts[toppingIdx], toppingIdx + 1, toppingCosts, target);   // 2 counts of curr topping
    }
}

// backtracking (for every base flavor, we can have 0, 1 or 2 of each topping)