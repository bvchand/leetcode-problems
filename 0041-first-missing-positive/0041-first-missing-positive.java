class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean onePresent = false;
        
        for(int num: nums)
            if(num == 1) {
                onePresent = true;
                break;
            }
                
        
        if(!onePresent)
            return 1;
        
        // data clean-up
        int n = nums.length;
        for(int i=0; i < n; i++) {
            if(nums[i] <= 0 || nums[i] > n)
                nums[i] = 1;
        }
        
        // now similar to find the duplicate number problem 
        for(int i=0; i < n; i++) {
            int index = Math.abs(nums[i]);
            if(index == n)
                nums[0] = -1 * Math.abs(nums[0]);
            else
                nums[index] = -1 * Math.abs(nums[index]);
        }
        
        for(int i=1; i < n; i++) {
            if(nums[i] > 0)
                return i;
        }
        
        if(nums[0] > 0)
            return n;
        return n+1;
    }
}