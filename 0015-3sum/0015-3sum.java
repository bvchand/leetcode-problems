class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length; i++) {
            if(i > 0 && nums[i-1] == nums[i])
                continue;
            
            // two sum
            int target = -1 * nums[i];
            Set<Integer> seen = new HashSet<>();
            for(int j = i+1; j < nums.length; j++) {
                int diff = target - nums[j];
                if(seen.contains(diff)) {
                    res.add(Arrays.asList(nums[i], nums[j], diff));
                    while(j+1 < nums.length && nums[j] == nums[j+1])
                        j++;
                }
                seen.add(nums[j]);
            }
        }
        return res;
    }
}