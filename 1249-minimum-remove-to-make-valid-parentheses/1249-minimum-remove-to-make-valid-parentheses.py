class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = []
        index_to_remove = set()
        
        for i in range(len(s)):
            if s[i] not in '()':    continue
            if s[i] == '(':
                stack.append(i)
            elif s[i] == ')' and not stack:
                index_to_remove.add(i)
            elif s[i] == ')':
                stack.pop()
            
        
        if stack:   index_to_remove = index_to_remove.union(set(stack))
        print(index_to_remove)
        
        result = ""
        for i in range(len(s)):
            if i in index_to_remove:    continue
            result += s[i]
            
        return result
    
# time:     O(n)
# space:    O(n)   
                
            
        
        