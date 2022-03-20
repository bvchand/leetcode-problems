class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x, n = 1/x, -n
            
        if n == 0:  return 1
        
        def helper(x, n):
            if n == 1:
                return x
            
            if n % 2 == 0:
                val = helper(x, n/2)
                return val * val
            else:
                val = helper(x, n//2)
                return x * val * val
        
        return helper(x, n)
            
            
        
        
        