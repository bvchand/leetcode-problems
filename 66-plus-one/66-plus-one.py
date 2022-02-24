"""
[1,2,3]

"""

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        i = len(digits)-1
        carry = 1
        result = []

        while i >= 0:
            res = digits[i] + carry
            result.append(res % 10)
            carry = res // 10 if res > 9 else 0
            i -= 1
            
        if carry:   result.append(carry)
        return result[::-1]
                
                
                
                