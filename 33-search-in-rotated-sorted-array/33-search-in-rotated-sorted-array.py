class Solution:
    def search(self, nums: List[int], target: int) -> int:
        """
        
        left, right = 0, len(nums)-1
        
        if target == nums[0]: return 0
        
        while left <= right:
            mid = left + (right-left)//2
            print(mid)
            
            if nums[mid] == target:
                return mid
            
            elif nums[mid] >= nums[left]:
                if target >= nums[left] and target < nums[mid]:
                    right = mid-1
                    
                else:
                    left = mid+1
            
            else:       # nums[mid] < nums[left]
                if target <= nums[right] and target > nums[mid]:
                    left = mid+1
                else:
                    right = mid-1
        
        return -1
        """
        
        left, right = 0, len(nums)-1
        
        while left <= right:
            mid = left + (right-left) // 2
            
            if nums[mid] == target:
                return mid
            
            elif nums[mid] >= nums[left]:
                if nums[left] <= target and target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
                    
                    
            
            else:       # nums[mid] < nums[left]
                if nums[mid] < target and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
                
        return -1