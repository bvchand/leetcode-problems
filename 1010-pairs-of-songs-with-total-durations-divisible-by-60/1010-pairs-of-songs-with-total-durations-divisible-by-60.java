/*
Strategy:
- bring all the values under the range of 60 by n%60.
- subtract the new values by 60 to get its complement and see if we have already encountered that. If we have increment the result counter.
- complement%60 is done for all the numbers divisible by 60 as they result in 0.
- increment the seen count for the current remainder.

time: O(N)
space: O(60) = O(1)

*/

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