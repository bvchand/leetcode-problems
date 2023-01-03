class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
                
        for(int i=0; i<intervals.length-1; i++) {
            // int[] curr = intervals[i];
            // int[] next = intervals[i+1];
            if(intervals[i+1][0] < intervals[i][1])
                return false;
        }
        
        return true;
    }
}