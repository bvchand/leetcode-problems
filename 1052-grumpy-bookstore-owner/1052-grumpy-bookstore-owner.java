class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int min) {
        int sum = 0, maxSatisfied = 0;
        
        for (int i=0, extra=0; i<customers.length; i++) {
            if (grumpy[i] == 0)
                sum += customers[i];
            else
                extra += customers[i];
            
            if (i >= min)
                extra -= customers[i - min] * grumpy[i - min];
            maxSatisfied = Math.max(extra, maxSatisfied);
        }
        return sum + maxSatisfied;
    }
}