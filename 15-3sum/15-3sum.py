class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        end = n-1
        nums.sort()
        result = []
        
        for i in range(n):
            if nums[i] > 0:     break
            if i==0 or nums[i-1] != nums[i]:
                self.twoSum(nums, i, result)
            
        return result
    
    def twoSum(self, nums: List[int], i: int, result:List[List[int]]):
        target = nums[i]
        seen = set()
        j =i+1
        
        while j < len(nums):
            diff = -target - nums[j]
            if diff in seen:
                result.append([target, nums[j], diff])
                while j + 1 < len(nums) and nums[j] == nums[j + 1]:
                    j += 1
            
            seen.add(nums[j])
            j += 1
        
        
            
                
            
            
                
                
                
            
        