/**
maxLen = 2
len = 2
  e k p w
[ 0 0 1 1     ]

0 1 2 3 4 5
p w w k e w
i
    j
**/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] mapS = new int[256];
        int slow = 0, fast = 0;
        int len = 0, maxLen = 0;
        
        Arrays.fill(mapS, 0);
        
        while (fast < s.length()) {
            char c1 = s.charAt(slow);
            char c2 = s.charAt(fast);
            if (mapS[c2] == 0) {
                mapS[c2]++;
                fast++;
                len++;
            } else {
                mapS[c1]--;
                slow++;
                len--;
            }
            
            maxLen = maxLen < len ? len : maxLen;
        }
        return maxLen;
    }
}