class Solution {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0 , p2 = 0;
        
        // if (s.length() == 0)
        //     return true;
        // if (s.length() > t.length())
        //     return false;
        
        while (p1 < s.length() && 
               p2 < t.length()) {
            char c1 = s.charAt(p1);
            char c2 = t.charAt(p2);
            if (c1 == c2) {
                p1++;
            }
            p2++;
        }
        return p1 == s.length();
    }
}

/**
space: O(1)
time: O(n); n --> length of t
**/