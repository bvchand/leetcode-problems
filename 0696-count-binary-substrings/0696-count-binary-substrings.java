class Solution {
    public int countBinarySubstrings(String s) {
        int preCnt = 0, curCnt = 1,  ans = 0, n = s.length();
        
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == s.charAt(i-1))
                curCnt++;
            else {
                ans += Math.min(preCnt, curCnt);
                preCnt = curCnt;
                curCnt = 1;
            }
        }
        return ans + Math.min(preCnt, curCnt);
    }
}

// maintain 2 counters (preCnt and curCnt) to count the number of matches found so far
// 