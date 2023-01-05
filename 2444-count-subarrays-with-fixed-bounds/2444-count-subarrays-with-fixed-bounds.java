class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minIndex = -1, maxIndex = -1, l = 0;
        long count = 0;
        
        for(int r = 0; r < nums.length; r++) {
            if(nums[r] < minK || nums[r] > maxK) {
                l = r + 1;
                minIndex = -1;
                maxIndex = -1;
            }
        
            if(nums[r] == minK)
                minIndex = r;
            
            if(nums[r] == maxK)
                maxIndex = r;
            
            // found both the minK and maxK
            if(minIndex != -1 && maxIndex != -1)
                // count += (r - l + 1) - (r - Math.min(minIndex, maxIndex));
                count += Math.min(minIndex, maxIndex) - l + 1;
            System.out.println(minIndex + " " + maxIndex + " " + count);
        }
        return count;
    }
}