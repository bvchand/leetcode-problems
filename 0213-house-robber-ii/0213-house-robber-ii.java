class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 0)
            return 0;
        
        if(n == 1)
            return nums[0];
        
        return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
    }
    
    public int rob(int[] nums, int start, int end) {
        int nextHouse = 0, next2NextHouse = 0;
        
        for(int i = start; i <= end; i++) {
            int temp = Math.max(nums[i] + next2NextHouse, nextHouse);
            next2NextHouse = nextHouse;
            nextHouse = temp;
        }
        
        return nextHouse;
    }
}