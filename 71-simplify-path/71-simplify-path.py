class Solution:
    def simplifyPath(self, path: str) -> str:
        path_list = path.strip().split('/')
        res = []    # stack
        
        for op in path_list:
            if res and op == '..':
                res.pop()
            elif op == '..' or op =='.' or op == "":
                continue
            else:       # directory name
                res.append(op)
        return '/'+'/'.join(res)
            
        