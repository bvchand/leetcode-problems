class Solution { //bottom up
    
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}

// class Solution { //top down
//     int count = 0;
    
//     public int helper(int n, int step, int[] memo) {   
//         if(step > n) {
//             return 0;
//         }
        
//         if(step == n) {
//             return 1;
//         }
        
//         if(memo[step] > 0)
//             return memo[step];

//         memo[step] = helper(n, step+1, memo) + helper(n, step+2, memo);
        
//         return memo[step];
//     }
    
//     public int climbStairs(int n) {
//         int steps = 0;
//         int[] memo = new int[n+1];
        
//         return helper(n, steps, memo);
//     }
// }