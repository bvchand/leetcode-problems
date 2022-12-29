class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int start = Integer.parseInt(loginTime.split(":")[0])*60 + Integer.parseInt(loginTime.split(":")[1]);
        int end = Integer.parseInt(logoutTime.split(":")[0])*60 + Integer.parseInt(logoutTime.split(":")[1]);
        
        if(start > end)
            end += (24*60);
        
        if(start % 15 != 0)
            start = start + 15 - (start % 15);
        
        return (end - start) / 15;
    }
}