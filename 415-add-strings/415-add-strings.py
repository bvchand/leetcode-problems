class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        res = []
        carry = 0
        i, j = len(num1)-1, len(num2)-1
        
        while i >= 0 or j >= 0:
            d1 = ord(num1[i]) - ord('0') if i >= 0 else 0
            d2 = ord(num2[j]) - ord('0') if j >= 0 else 0
            
            value = (d1 + d2 + carry) % 10
            carry = (d1 + d2 + carry) // 10
            
            res.append(str(value))
            i -= 1
            j -= 1
        
        if carry:   res.append(str(carry))
        
        return "".join(res[::-1])
    
"""
time: O(N)
space = O(N)
"""
            
            
            
            
        
                       