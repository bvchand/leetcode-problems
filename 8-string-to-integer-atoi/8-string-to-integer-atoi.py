class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        
        if s == "": return 0
        
        n, index, is_negative = 0, 0, False
        
        INT_MAX = pow(2,31) - 1 
        INT_MIN = -pow(2,31)
               
        if s[0] == '-':
            is_negative = True
            index += 1
        elif s[0] == '+': 
            is_negative = False
            index += 1
        
        while index<len(s) and s[index].isdigit():
            n = n * 10 + string.digits.index(s[index])
            index += 1
                
        n = -1*n if is_negative else n
        
        if n > INT_MAX: n = INT_MAX 
        if n < INT_MIN: n = INT_MIN
        
        return n
         
            