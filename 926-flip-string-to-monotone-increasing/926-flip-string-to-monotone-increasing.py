class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        nflips, ones = 0, 0         # nflips --> zeros; after every iteration, change the nflips
        
        for d in s:
            if d == '0':
                nflips += 1
            elif d == '1':
                ones += 1
            
            nflips = min(nflips, ones)
        
        return nflips
                