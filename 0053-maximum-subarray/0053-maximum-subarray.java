class Solution {
    public int maxSubArray(int[] nums) {
        int currSubarray = nums[0];
        int maxSubArray = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            int num = nums[i];
            currSubarray = Math.max(num, currSubarray+num);
            maxSubArray = Math.max(maxSubArray, currSubarray);
        }
        return maxSubArray;
    }
}