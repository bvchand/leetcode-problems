class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        // boolean[] dp = new boolean[n];
        // dp[n-1] = true;
        int lastPos = n-1;
        
        for(int i=n-1; i>=0; i--) {
            int sum = i + nums[i];
            if(sum >= lastPos)
                lastPos = i;
        }
        return lastPos == 0;
    }
}