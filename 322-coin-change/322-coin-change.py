class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [sys.maxsize] * (amount+1)    # cache
        dp[0] = 0                        # zero coins needed to accumulate zero amount
        
        for a in range(1, amount+1):
            for c in coins:
                if c <= a:
                    dp[a] = min(1+dp[a-c], dp[a])
        
        return dp[amount] if dp[amount] != sys.maxsize else -1
            
        
        
        
        