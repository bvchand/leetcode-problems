class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        k = len(nums) - k       # index of element to be found
        
        def quickSelect(l, r):
            pivot, p = nums[r], l
        
            for i in range(l, r):
                if nums[i] <= pivot:
                    nums[i], nums[p] = nums[p], nums[i]
                    p += 1
            
            nums[p], nums[r] = nums[r], nums[p]     # bring the pivot element to it's final position
            
            if p < k:   return quickSelect(p+1, r)
            elif p > k: return quickSelect(l, p-1)
            else:       return nums[p]
            
        return quickSelect(0, len(nums)-1)
    
"""
time: 
    avg case: O(N) 
    worse case: O(N^2)
space: O(1)
"""
                
                
                
                    
        
        