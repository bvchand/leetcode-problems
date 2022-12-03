/*
num = 4
j
i

[0,0,1,1,1,2,2,3,3,4]
     i
   j
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }
}