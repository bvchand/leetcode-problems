class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        pLetters, sLetters = Counter(p), Counter()
        pLen, sLen = len(p), len(s)
        result = []
        
        for i in range(sLen):
            sLetters[s[i]] += 1
            if i >= pLen:
                if sLetters[s[i-pLen]] == 1:  del sLetters[s[i-pLen]]
                else:   sLetters[s[i-pLen]] -= 1
            if sLetters == pLetters:
                    result.append(i-pLen+1)

        return result
                    
            
            
            
        
        