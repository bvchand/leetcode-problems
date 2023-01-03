class Solution {
    public boolean detectCapitalUse(String word) {
        int capCount = 0;
        
        for(char c: word.toCharArray()) {
            if(Character.isUpperCase(c))
                capCount++;
        }
        
        return capCount == 0 || capCount == word.length() || (capCount == 1 && Character.isUpperCase(word.charAt(0)));
    }
}