// class Solution {
//     public int countBinarySubstrings(String s) {
//         int preCnt = 0, curCnt = 1,  ans = 0, n = s.length();
        
//         for(int i = 1; i < n; i++) {
//             if(s.charAt(i) == s.charAt(i-1))
//                 curCnt++;
//             else {
//                 ans += Math.min(preCnt, curCnt);
//                 preCnt = curCnt;
//                 curCnt = 1;
//             }
//         }
//         return ans + Math.min(preCnt, curCnt);
//     }
// }

// maintain 2 counters (preCnt and curCnt) to count the number of matches found so far
// 


class Solution {
    public int countBinarySubstrings(String s) {
        int preCnt = 0, ans = 0, n = s.length();
        
        for(int i = 0; i < n; i++) {
            int curCnt = 1;
            while(i < n-1 && s.charAt(i) == s.charAt(i+1)) {
                curCnt++;
                i++;
            }
            if(preCnt > 0) {
                ans += Math.min(preCnt, curCnt);
            }
            preCnt = curCnt;
        }
        return ans;
    }
}