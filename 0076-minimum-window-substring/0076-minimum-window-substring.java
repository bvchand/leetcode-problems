class Solution {
    public String minWindow(String s, String t) {
        
        if(t.equals(""))
            return "";
                
        Map<Character, Integer> tc = new HashMap<>();
        Map<Character, Integer> sc = new HashMap<>();
        
        for(char c: t.toCharArray())
            tc.put(c, tc.getOrDefault(c, 0)+1);
        
        int have = 0, need = t.length();
        int start = -1, end = -1, resLen = Integer.MAX_VALUE;     // ans
        int left = 0;
   
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            sc.put(c, sc.getOrDefault(c, 0)+1);
            
            if(tc.containsKey(c) && sc.get(c) <= tc.get(c))
                have += 1;
            
            while(have == need) {
                if(right - left + 1 < resLen) {
                    start = left;
                    end = right;
                    resLen = right - left + 1; 
                }
                
                char leftChar = s.charAt(left);
                sc.put(leftChar, sc.get(leftChar)-1);
                if(tc.containsKey(leftChar) && sc.get(leftChar) < tc.get(leftChar))
                    have -= 1;
                left++;
            }
        }
        return resLen != Integer.MAX_VALUE ? s.substring(start, end+1) : "";
    }
}