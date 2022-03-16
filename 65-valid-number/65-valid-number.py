class Solution:
    def isNumber(self, s: str) -> bool:
        seen_digit, seen_exp, seen_dot = 0, 0, 0
        signs = ('+', '-')
        
    
        for i in range(len(s)):
            if s[i].isnumeric():
                seen_digit = True
            
            elif s[i] in signs:
                if i > 0 and s[i-1] not in ('e', 'E'):
                    return False
            
            elif i > 0 and s[i] in ('e', 'E'):
                if seen_exp or not seen_digit:
                    return False
                seen_exp = True
                seen_digit = False
            
            elif s[i] == '.':
                if seen_dot or seen_exp:
                    return False
                seen_dot = True
            
            else:
                return False
            
        return seen_digit