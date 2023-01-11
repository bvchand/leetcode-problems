class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int n = word1.length();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<n; i++) {
            char c1 = word1.charAt(i), c2 = word2.charAt(i);
            map1.put(c1, map1.getOrDefault(c1, 0)+1);
            map2.put(c2, map2.getOrDefault(c2, 0)+1);
        }
        
        for(char c: map1.keySet()) {
            int count1 = map1.get(c);
            int count2 = map2.getOrDefault(c, 0);
            if(Math.abs(count1-count2) > 3)
                return false;
        }
        
        for(char c: map2.keySet()) {
            int count1 = map2.get(c);
            int count2 = map1.getOrDefault(c, 0);
            if(Math.abs(count1-count2) > 3)
                return false;
        }
        
        return true;
    }
}