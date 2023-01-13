class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        // minIdx is to track at what point the amount of gas stops reducing
        // the index where the minIdx stops changing, starting index = minInd+1
        int minIdx = 0;
        int minAmount = Integer.MAX_VALUE;
        
        int gasInTank = 0;
        
        for(int i = 0; i < n; i++) {
            gasInTank += (gas[i] - cost[i]);
            if(gasInTank < minAmount) {
                minIdx = i;
                minAmount = gasInTank;
            }    
        }
        if(gasInTank < 0)
            return -1;
        return (minIdx + 1) % n;
    }
}

// time = O(N), space:O(1)