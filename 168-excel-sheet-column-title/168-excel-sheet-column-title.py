class Solution:
    def convertToTitle(self, num: int) -> str:
        dist, res = ord('A'), []
        while num > 0:
            rem = (num-1) % 26
            num = (num-1) // 26
            res.append(chr(rem+dist))
        return ''.join(reversed(res))
            
            
            