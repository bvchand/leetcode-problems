class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        
        TC:
        [1,4,7,4,9,7,6,5,3]
        [9]
        []
        [1,2,3]
        [3,2,1]
        
        Pseudocode:
        traverse from right-to-left until nums[i-1] < nums[i] - while
        if i == 0:   nums.reverse() return
        else:   j = i
        traverse forward from j to find the next big number from nums[i-1]
        swap nums[i-1] and nums[j]
        
        """
        
        def swap(i, j):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            
        def reverse(i, j):
            while i < j:
                swap(i, j)
                i += 1
                j -= 1
            
        i = len(nums)-1
        
        while i >= 0 and nums[i-1] >= nums[i]:
            i -= 1
        i-=1
        if i >= 0:
            j = len(nums)-1
            while nums[j] <= nums[i]:
                j -= 1
            swap(i, j)
        reverse(i+1, len(nums)-1)
        
            
            
            