class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        if k < 0 or len(nums) < 2:
            return False
        tot = 0
        sum_idx_map = {0:-1}    # remainder:index
        for i in range(len(nums)):
            tot += nums[i]
            rem = tot % k
            if rem not in sum_idx_map:
                sum_idx_map[rem] = i
            elif i-sum_idx_map[rem] > 1:
                return True
        return False