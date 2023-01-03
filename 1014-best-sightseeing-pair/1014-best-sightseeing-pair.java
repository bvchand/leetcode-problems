class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = values[0];
        int prevBestIndex = 0;
        
        for(int i=1; i<values.length; i++) {
            int currScore = values[prevBestIndex] + values[i] - (i - prevBestIndex);
            maxScore = Math.max(maxScore, currScore);
            
            if((values[prevBestIndex] + prevBestIndex) < (values[i] + i)) {
                prevBestIndex = i;     // max between the prev best value and curr value
            }
        }
        return maxScore;
    }
}