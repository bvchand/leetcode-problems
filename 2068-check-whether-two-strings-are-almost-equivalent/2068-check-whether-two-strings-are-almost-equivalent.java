class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int n = word1.length();
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for(int i=0; i<n; i++) {
            char c1 = word1.charAt(i), c2 = word2.charAt(i);
            map1[c1 - 'a']++;
            map2[c2 - 'a']++;
        }
        
        for(int i=0; i<26; i++) {
            int count1 = map1[i], count2 = map2[i];
            if(Math.abs(count1-count2) > 3)
                return false;
        }
        
        return true;
    }
}