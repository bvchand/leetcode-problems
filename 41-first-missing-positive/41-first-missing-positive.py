class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        sort_nums = sorted(nums)
        res = 1
        
        for n in sort_nums:
            if res == n:
                res += 1
        return res
        
        