class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        pLetters, sLetters = {}, {}
        result = []
        
        for c in p:
            pLetters[c] = 1 if c not in pLetters else pLetters[c] + 1
        
        start, end, i = 0, len(p), 0
        while end <= len(s):
            if i >= start and i < end:
                char = s[i]
                sLetters[char] = 1 if char not in sLetters else sLetters[char] + 1
                i += 1
            elif i == end:
                if sLetters == pLetters:
                    result.append(start)
                if sLetters[s[start]] - 1 == 0:  sLetters.pop(s[start])
                else:   sLetters[s[start]] -= 1
                start += 1
                end += 1

        return result
                    
            
            
            
        
        