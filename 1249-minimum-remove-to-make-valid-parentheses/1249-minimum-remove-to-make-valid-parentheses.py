"""
0 1 2 3 4 5 6 7 8 9 10 11 12
l e e ( t ( c ) o ) d  e  )



stack = []
set = (12)
res = 

"""


class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = []
        invalid_index = set()
        res = []
        
        for i in range(len(s)):
            if s[i] not in '()':
                continue
            elif s[i] == '(':
                stack.append(i)
            elif stack and s[i] == ')':
                stack.pop()
            elif s[i] == ')':
                invalid_index.add(i)
        
        if stack:
            for i in stack:      invalid_index.add(i) 
        
        for i in range(len(s)):
            if i not in invalid_index:
                res.append(s[i])
        
        return ''.join(res)
        
                
        
        