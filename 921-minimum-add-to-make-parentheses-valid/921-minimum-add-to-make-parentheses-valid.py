class Solution:
    def minAddToMakeValid(self, s: str) -> int:
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
        
        return len(invalid_index)