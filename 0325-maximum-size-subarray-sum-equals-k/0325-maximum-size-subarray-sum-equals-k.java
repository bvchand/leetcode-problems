class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int n = nums.length;
        int maxLen = Integer.MIN_VALUE;
        int prefixsum = 0;
        
        for(int i = 0; i < n; i++) {
            prefixsum += nums[i];
            
            if(prefixsum == k)
                maxLen = i+1;
            
            if(indexMap.containsKey(prefixsum - k))
                maxLen = Math.max(maxLen, i - indexMap.get(prefixsum - k));
            if(!indexMap.containsKey(prefixsum))
                indexMap.put(prefixsum, i);
        }
        
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}