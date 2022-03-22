class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
#         hash = defaultdict(int)
#         hash[0] = 1
#         curr_sum, count = 0, 0
        
#         for i in range(len(nums)):
#             curr_sum += nums[i]
#             if curr_sum - k in hash:
#                     count += hash[curr_sum - k]
#             hash[curr_sum] += 1
        
#         return count
        hash = defaultdict(int)
        hash[0] = 1
        curr_sum = count = 0
        
        for i in range(len(nums)):
            curr_sum += nums[i]
            if (curr_sum - k) in hash:
                count += hash[curr_sum - k]
            hash[curr_sum] += 1
        
        return count