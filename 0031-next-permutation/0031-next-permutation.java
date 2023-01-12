class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int n, int i) {
        int j = n-1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n-2;
        
        while(i >= 0 && nums[i+1] <= nums[i])
            i--;
        if(i >= 0) {
            int j = n - 1;
            while(nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, n, i+1);
    }
}