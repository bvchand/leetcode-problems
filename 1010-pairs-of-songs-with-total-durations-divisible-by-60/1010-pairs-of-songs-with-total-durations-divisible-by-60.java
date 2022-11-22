class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[] seen = new int[60];
        
        for (int t: time) {
            int rem = t % 60;
            int complement = (60 - rem) % 60;
            res += seen[complement];
            seen[rem]++;
        }
        return res;
        
    }
}