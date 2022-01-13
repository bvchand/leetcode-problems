class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        hay_len = len(haystack)
        needle_len = len(needle)
        
        if not haystack and not needle:  return 0
        
        if needle_len > hay_len: return -1
        
        # i = 0
        
        for i in range(0, hay_len-needle_len+1):
            # print(i, i+needle_len-1)
            temp = haystack[i:i+needle_len]
            # print(temp)
            if temp == needle:
                return i
            i += 1
        return -1
            
            
             
            
            
        
        
        
        
        
        