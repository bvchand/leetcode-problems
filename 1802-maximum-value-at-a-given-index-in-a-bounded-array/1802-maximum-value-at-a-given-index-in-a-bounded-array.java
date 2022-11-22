/**
Strategy: Binary search

*/

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        long leftSpaces = index, rightSpaces = n - index - 1;
        long lo = 1, hi = maxSum;
        long mid;
        long res = 0;
        
        while (lo <= hi) {
            mid = lo + (hi-lo)/2;
            long leftSum, rightSum;
            long m = mid-1;
            long sum = 0;
            
            // Calculate the left sum
            // If number of left spaces < mid-1 value, we need to calculate the partial sum (so subtract the sum upto m-leftspaces from the total sum)
            // If number of left spaces > mid-1 value, need to add extra 1's
            if (leftSpaces <= m) {
                leftSum = m*(m+1)/2 - ((m-leftSpaces)*(m-leftSpaces+1)/2);
            } else {
                leftSum = m*(m+1)/2 + 1*(leftSpaces-m);
            }
            
            if (rightSpaces <= m) {
                rightSum = m*(m+1)/2 - ((m-rightSpaces)*(m-rightSpaces+1)/2);
            } else {
                rightSum = m*(m+1)/2 + 1*(rightSpaces-m);
            }
            
            // since mid is not used to calculate left and right sum
            sum = mid + leftSum + rightSum;
            
            if (sum <= maxSum) {
                res = mid;
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        } 
        return (int) res;
    }
}