"""
[2,3,-2,4]



"""

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        curr, min_so_far, max_so_far, res = nums[0], nums[0], nums[0], nums[0]
        
        for i in range(1, len(nums)):
            curr = nums[i]
            temp_min = min(curr, curr*min_so_far, curr*max_so_far)
            max_so_far = max(curr, curr*min_so_far, curr*max_so_far)
            
            min_so_far = temp_min
            res = max(res, max_so_far)
        
        return res
            
            
        