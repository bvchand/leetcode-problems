class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] s2t = new int[256], t2s = new int[256];
        
        Arrays.fill(s2t, -1);
        Arrays.fill(t2s, -1);
        
        if (s.length() != t.length())
            return false;
        
        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            
            if (s2t[c1] == -1 && t2s[c2] == -1) {
                s2t[c1] = c2;
                t2s[c2] = c1;
            }
                
            if (!(s2t[c1] == c2 && t2s[c2] == c1)){
                return false;
            }
            
        }
        return true;
    }
}