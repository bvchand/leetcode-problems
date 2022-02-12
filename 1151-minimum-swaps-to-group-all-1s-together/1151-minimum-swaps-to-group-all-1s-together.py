class Solution:
    def minSwaps(self, data: List[int]) -> int:
        ones = data.count(1)
        left, right = 0, 0
        sub_ones, tot_ones = 0, 0
        while right < len(data):
            sub_ones += data[right]
            right += 1
            tot_ones = max(tot_ones, sub_ones)
            if (right - left) >= ones:
                sub_ones -= data[left]
                left += 1
            
        return ones - tot_ones
                