class Solution {
    public int findDuplicate(int[] nums) {
        int nextIndex = 0;
        for(int i=0; i<nums.length; i++) {
            nextIndex = Math.abs(nums[i]);
            if (nums[nextIndex] < 0)
                break;
            nums[nextIndex] = -1*nums[nextIndex];
        }
        return nextIndex;
    }
}

/*
 0  1  2  3  4
[1,-3,-4,-2,-2]

[1,3,4,2,2]
   i


*/