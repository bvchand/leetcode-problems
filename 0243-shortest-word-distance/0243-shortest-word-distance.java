class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int minDist = Integer.MAX_VALUE;
        int word1Index = -1, word2Index = -1;
        for(int i=0; i<wordsDict.length; i++) {
            if(wordsDict[i].equals(word1))
                word1Index = i;
            if(wordsDict[i].equals(word2))
                word2Index = i;

            if(word1Index != -1 && word2Index != -1)
                minDist = Math.min(minDist, Math.abs(word1Index - word2Index));
        }
        return minDist;
    }
}