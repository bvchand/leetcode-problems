class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] timeSeen = new boolean[24*60];    // 1440
        
        // convert all the HH:MM to minutes and fill in a boolean array with minutes seen
        for(String timePoint: timePoints) {
            String[] time = timePoint.split(":");
            int hour = Integer.parseInt(time[0]), min = Integer.parseInt(time[1]);
            int currTime = hour * 60 + min;
            
            if(timeSeen[currTime])
                return 0;
            
            timeSeen[currTime] = true;
        }
        
        Integer firstTime = null, prevTime = null;
        int minDiff = Integer.MAX_VALUE;
        
        // traverse through the boolean array and check the diff between 2 consecutive "seen" times, both forwards and backwards, and compute the min diff
        for(int i=0; i<timeSeen.length; i++) {
            if(timeSeen[i] == true) {
                if(firstTime == null) {
                    firstTime = i;
                    prevTime = i;
                } else {
                    minDiff = Math.min(minDiff, Math.min((i-prevTime), (1440-i+prevTime)));
                    prevTime = i;
                } 
            }
        }
        
        minDiff = Math.min(minDiff, Math.min((prevTime - firstTime), (1440-prevTime+firstTime)));   
        return minDiff;
    }
}