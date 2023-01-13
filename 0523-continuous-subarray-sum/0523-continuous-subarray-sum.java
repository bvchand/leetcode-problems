class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if(!map.containsKey(rem))
                map.put(rem, i+1);
            else if(map.get(rem) < i)
                return true;
        }
        return false;
    }
}