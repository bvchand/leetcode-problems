class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hmap = {}
        n = len(nums)
        
        for i in range(n):
            diff = target - nums[i]
            if diff in hmap:    return [i, hmap[diff]]
            hmap[nums[i]] = i
            
            
        