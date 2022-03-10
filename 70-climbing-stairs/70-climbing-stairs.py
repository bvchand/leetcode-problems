class Solution:
    def climbStairs(self, n: int) -> int:
        first, second = 1, 1        # first -- at last step; second -- from penultimate step
        res = 0
        
        for i in range(n-1):
            temp = second
            second = first + second
            first = temp
        
        return second
        
        