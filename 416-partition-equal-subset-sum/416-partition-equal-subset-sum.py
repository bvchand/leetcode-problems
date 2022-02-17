class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        n = len(nums)
        total = sum(nums)
        
        if total % 2 != 0:    return False
        target = total//2
        
        # top_down - DFS
        """
        def top_down(nums, n, target):
            # base case
            if target == 0: return True
            if n == 0 or target < 0:    return False
            
            # reducing the subset sum
            result = top_down(nums, n-1, target - nums[n-1])  or \
                        top_down(nums, n-1, target)
            
            return result
        
        return top_down(tuple(nums), n-1, subset_sum)
        """
        
        # bottom-up
        dp = set()
        dp.add(0)
        
        for i in range(n):
            newDP = dp.copy()
            for s in dp:
                newDP.add(nums[i] + s)
            if target in newDP:
                return True
            dp = newDP
        return False
        
            
            
            