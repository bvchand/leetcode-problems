class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] timeTaken = new double[target];
        int res = 0;
        
        for(int i=0; i<n; i++)
            timeTaken[position[i]] = (double) (target - position[i])/speed[i];
        
        double prev = 0.0;
        for(int i=timeTaken.length-1; i>=0; i--) {
            double curr = timeTaken[i];
            if(curr > prev) {
                System.out.println(curr + " " + prev);
                res++;
                prev = curr;
            }
                
        }
        return res;
    }
}