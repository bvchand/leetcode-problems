class Solution:
    def validPalindrome(self, s: str) -> bool:
        left, right = 0, len(s)-1
        
        def checkPalindrome(left, right):
            while left < right:
                if s[left] != s[right]:
                    return False
                left += 1
                right -= 1  
            return True
            
        while left < right:
            if s[left] != s[right]:
                return checkPalindrome(left+1, right) or \
                       checkPalindrome(left, right-1)
            left += 1
            right -= 1
        
        return True
    
"""
time: O(N)
space: O(1)
"""