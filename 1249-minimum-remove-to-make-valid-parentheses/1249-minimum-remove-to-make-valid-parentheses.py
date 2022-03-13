class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        invalid_index = set()
        stack = []
        
        for i,c in enumerate(s):
            if c not in '()':
                continue
            elif c == '(':
                stack.append(i)
            elif stack and c == ')':
                stack.pop()
            elif c == ')':
                invalid_index.add(i)
        
        if stack:  
            for i in stack:     invalid_index.add(i)
        
        res = []
        
        for i in range(len(s)):
            if i not in invalid_index:  res.append(s[i])
        
        return ''.join(res)
        