class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCount = new int[26];
        
        for(String word: words2) {
            int[] word2Count = count(word);
            
            for(int i=0; i<26; i++) {
                maxCount[i] = Math.max(maxCount[i], word2Count[i]);
            }
        }
    
        List<String> res = new ArrayList();
        search:
        for(String word: words1) {
            int[] word1Count = count(word);
            for(int i=0; i<26; i++) {
                if(word1Count[i] < maxCount[i])
                    continue search;
            }
            res.add(word);
        }
        return res;
    }
    
    private int[] count(String word) {
        int[] wordCount = new int[26];
        for(char c: word.toCharArray()) {
            wordCount[c - 'a']++;
        }
        return wordCount;
    }
}