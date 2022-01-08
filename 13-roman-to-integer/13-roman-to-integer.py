class Solution:
    def romanToInt(self, s: str) -> int:
        roman_to_int = {'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000,
                 'IV':4, 'IX':9, 'XL':40, 'XC':90, 'CD':400, 'CM':900}
        
        if s in roman_to_int:
            return roman_to_int[s]
        
        res, i = 0, 0
        while i<len(s):
            if i<len(s)-1 and s[i]+s[i+1] in roman_to_int:
                res += roman_to_int[s[i]+s[i+1]]
                i += 1
            elif s[i] in roman_to_int:
                res += roman_to_int[s[i]]
            i += 1
        return res
        
        
        
            