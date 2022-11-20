class Solution {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0 , p2 = 0;
        int charFound = 0;
        
        if (s.length() == 0)
            return true;
        if (s.length() > t.length())
            return false;
        
        while (p1 < s.length() && 
               p2 < t.length()) {
            char c1 = s.charAt(p1);
            char c2 = t.charAt(p2);
            if (c1 == c2) {
                charFound++;
                p1++;
                p2++;
            } else {
                p2++;
            }
        }
        if (charFound == s.length()) {
            return true;
        }
        return false;
    }
}

/**
space: O(1)
time: O(n)
**/