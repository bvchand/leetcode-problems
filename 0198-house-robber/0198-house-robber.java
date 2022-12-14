class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] amountRobbed = new int[n+1];
        
        amountRobbed[n] = 0;
        amountRobbed[n-1] = nums[n-1];
        
        for(int i = n-2; i >= 0; i--) {
            amountRobbed[i] = Math.max(nums[i] + amountRobbed[i+2], amountRobbed[i+1]);
        }
        
        return amountRobbed[0];
    }
}