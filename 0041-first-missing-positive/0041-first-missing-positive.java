class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            if(num > 0)
                set.add(num);
            else
                set.add(0);
        }
        int i=1;
        while(i <= nums.length) {
            if(!set.contains(i))
                return i;
            i++;
        }
        return i;
    }
}