"""
[1,2,3]
[9]
[1,2,-3]
[]


time: O(N)
space = O(N) --> worst case O(1) best case
"""

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        i = len(digits)-1
        carry = 1

        while i >= 0:
            res = digits[i] + carry
            digits[i] = res % 10
            carry = res // 10 if res > 9 else 0
            i -= 1
            
        return [carry] + digits if carry else digits

    
                
                
                
                