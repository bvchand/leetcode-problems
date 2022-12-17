class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int bananasPerPile: piles)
            maxPile = Math.max(bananasPerPile, maxPile);
        
        int left = 1, right = maxPile; // left --> slowest possible speed, right --> highest possible speed
        
        while(left < right) {
            int midSpeed = left + (right - left)/2;
            double hoursSpent = 0;
            
            for(int bananasPerPile: piles)
                hoursSpent += Math.ceil((double) bananasPerPile/midSpeed);
            
            if(hoursSpent <= h) // can eat a little slower
                right = midSpeed;
            else if(hoursSpent > h) // should eat a little faster
                left = midSpeed + 1; 
            // else
            //     return midSpeed;
        }
        return right;
    }
}

// approach --> binary search for the speed (1 to max(piles))