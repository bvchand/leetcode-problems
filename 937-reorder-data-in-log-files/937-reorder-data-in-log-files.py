class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        
        def get_key(log):
            iden, content = log.split(" ", 1)
            if content[0] in string.digits:
                return (1, )
            else:
                return (0, content, iden)
        
        return sorted(logs, key=get_key)