class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        min_add = open_ = close = 0
        
        for i in range(len(s)):
            if s[i] == '(':
                open_ += 1
            else:
                if open_ == close:
                    min_add += 1
                else:
                    close += 1
        
        return min_add + open_ - close

"""
time: O(n)
space: O(1)
"""
                