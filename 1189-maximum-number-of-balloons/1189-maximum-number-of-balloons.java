class Solution {
    public int maxNumberOfBalloons(String text) {
        String pattern = "balloon";
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> textMap = new HashMap<>();
        
        for(char c: pattern.toCharArray())
            patternMap.put(c, patternMap.getOrDefault(c, 0)+1);
        
        for(char c: text.toCharArray())
            textMap.put(c, textMap.getOrDefault(c, 0)+1);
        
        int ans = Integer.MAX_VALUE;
        for(char c: pattern.toCharArray()) {
            int textCount = textMap.getOrDefault(c, 0);
            int patternCount = patternMap.getOrDefault(c, 0);
            ans = Math.min(textCount/patternCount, ans);
        }
        
        return ans;
    }
}