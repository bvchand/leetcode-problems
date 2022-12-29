class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        String[] time = loginTime.split(":");
        int start = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
        
        time = logoutTime.split(":");
        int end = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
        
        if(start > end)
            end += (24*60);
        
        if(start % 15 != 0)
            start = start + 15 - (start % 15);
        
        return (end - start) / 15;
    }
}