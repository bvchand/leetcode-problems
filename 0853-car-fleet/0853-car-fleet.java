// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//         int n = position.length;
        
//         int[][] posSpeed = new int[n][2];
        
//         for(int i=0; i<n; i++)
//             posSpeed[i] = new int[]{position[i], speed[i]};
        
//         Arrays.sort(posSpeed, (a,b) -> Integer.compare(a[0], b[0]));
//         Stack<Double> stack = new Stack<>();
//         double prev = 0.0;
        
//         for(int i=n-1; i>=0; i--) {
//             int pos = posSpeed[i][0], pace = posSpeed[i][1];
//             double currDuration = (double) (target-pos)/pace;
            
//             if(!stack.isEmpty()) 
//                 prev = stack.peek();
            
//             stack.push(currDuration);
//             if(stack.size() >= 2 && currDuration <= prev) {
//                 stack.pop();
//             }  
//         }
//         return stack.size();
//     }
// }


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
                // System.out.println(curr + " " + prev);
                res++;
                prev = curr;
            }
                
        }
        return res;
    }
}