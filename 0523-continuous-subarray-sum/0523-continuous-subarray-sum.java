class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if(!map.containsKey(rem))
                map.put(rem, i);
            else if(i - map.get(rem) > 1)
                return true;
        }
        return false;
    }
}

// prefix sum
// calculate the cumulative sum at every index and add the rem to a hash map
// if the rem already exists and the previous index and the current index > 1 --> true