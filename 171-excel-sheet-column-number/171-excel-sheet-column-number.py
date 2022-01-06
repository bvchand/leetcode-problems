class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        l = len(columnTitle)-1
        res = 0 
        for c in columnTitle:
            res += pow(26, l) * (ord(c)-ord('A')+1)
            l -= 1
        return res
        
        