class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = ''.join([ch for ch in s if ch.isalnum()]).lower()
        
        front, back = 0, len(s)-1
        
        while front < back:
            if s[front] == s[back]:
                front += 1
                back -= 1
            else:
                return False
        
        return True
        