"""
 0,1,2,3,4,5,6
[2,5,6,0,0,1,2]     t=0     --> mid == t --> True
 l     m     r
 
 
 0,1,2,3,4,5,6
[2,5,6,0,0,1,2]     t=1     
 l     m     r
 
 
 
"""


class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        left, right = 0, len(nums)-1
        
        while left <= right:
            mid = left + (right-left)//2
            
            if nums[mid] == target:     return True
            
            elif nums[mid] >= nums[left]:
                if target >= nums[left] and target < nums[mid]:        # first array
                    right = mid-1
                else:
                    left += 1
            
            else:           # nums[mid] < nums[left] -- second array
                if target <= nums[right] and target > nums[mid]:
                    left += 1
                else:
                    right -= 1
        return False
                    
        