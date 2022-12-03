class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int nextIndex = Math.abs(nums[i]);
            if (nums[nextIndex] < 0)
                return nextIndex;
            nums[nextIndex] = -1*nums[nextIndex];
        }
        return -1;
    }
}

/*
 0  1  2  3  4
[1,-3,-4,-2,-2]

[1,3,4,2,2]
   i


*/