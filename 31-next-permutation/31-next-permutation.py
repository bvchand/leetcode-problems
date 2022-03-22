class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        
        [3,2,1,9,7,6] --> [3,2,1,9,7,6] --> [3,2,6,9,7,1] --> [3,2,1,6,7,9]
               i               i   
                                     j
        
        [1,2,4,3,1] --> [1,3,4,2,1] --> [1,3,1,2,4]
    
        """
        
        def swap(i, j):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        
        
        i = len(nums)-1     # find the first smallest number
        
        while i > 0:
            if nums[i-1] < nums[i]:
                break
            i -= 1
        i = i-1
        if i >= 0:
            j = len(nums)-1
            while j > i:
                if nums[j] > nums[i]:
                    swap(j,i)
                    break
                j -= 1
        i, j = i+1, len(nums)-1
        # print(i, j)
        # print(nums)
        while i < j:
            swap(i, j)
            i += 1
            j -= 1
        # print(nums)
            
                
            
        
        
        
        