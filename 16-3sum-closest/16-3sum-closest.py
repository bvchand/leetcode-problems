class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        n = len(nums)
        minDist = float("inf")
        
        for i in range(n-2):
            l, r = i+1, n-1
            newTarget = target - nums[i]
            
            while l < r:
                twoSum = nums[l] + nums[r]
                
                if abs(minDist) > abs(newTarget - twoSum):
                    minDist = newTarget - twoSum
                                
                if twoSum == newTarget:
                    return target
                elif twoSum < newTarget:
                    l += 1
                else:
                    r -= 1
            
            if minDist == 0:
                break
            
        return target-minDist

"""
time: O(N^2)
space: O(log N) to O(N) depending on sort implementation
"""
                
                
                    
        