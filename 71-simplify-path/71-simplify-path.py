class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        
        for clause in path.split('/'):
            if clause == '..':
                if stack:   stack.pop()
            elif clause == '.' or clause == '': continue
            else:   stack.append(clause)
        
        res = '/' + '/'.join(stack)
        return res
        
        
                        
            
        