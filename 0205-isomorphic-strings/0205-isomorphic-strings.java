class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();
        if (s.length() != t.length())
            return false;
        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            
            if (!s2t.containsKey(c1) && !t2s.containsKey(c2)) {
                s2t.put(c1, c2);
                t2s.put(c2, c1);
            }
                
                
            if ((s2t.containsKey(c1) && 
                c2 != s2t.get(c1)) ||
                (t2s.containsKey(c2) && 
                c1 != t2s.get(c2))
               ){
                return false;
            }
            
        }
        return true;
    }
}