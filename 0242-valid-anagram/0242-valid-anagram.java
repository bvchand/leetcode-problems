class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charCount = new HashMap<>();
        
        for(char c: s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0)+1);
        }
        
        for(char c: t.toCharArray()) {
            if(charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c)-1);
                if(charCount.get(c) == 0)
                    charCount.remove(c);
            } else {
                return false;
            }
        }
        
        return charCount.size() == 0;
        
    }
}