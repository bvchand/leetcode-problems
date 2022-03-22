class Solution:

    def __init__(self, w: List[int]):

        self.prefix_sums = []
        prefix_sum = 0
        for weight in w:            # add the cum sum in the list for each index
            prefix_sum += weight
            self.prefix_sums.append(prefix_sum)
        self.total_sum = prefix_sum

    def pickIndex(self) -> int:
        target = self.total_sum * random.random()       # generate a rand index based on the total sum
        
        # run a binary search to find the target bucket
        left, right = 0, len(self.prefix_sums)      
        while left < right:
            mid = left + (right - left) // 2
            if target > self.prefix_sums[mid]:
                left = mid + 1
            else:
                right = mid
        return left
        
"""
time:   O(N) - init
        O(log N) - pickIndex
space:  O(N) - init
        O(1) - pickIndex

"""

# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()