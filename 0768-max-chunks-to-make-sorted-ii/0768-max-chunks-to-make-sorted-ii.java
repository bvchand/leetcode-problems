// class Solution {
//     public int maxChunksToSorted(int[] arr) {
//         int N = arr.length;
        
//         int[] maxFromLeft = new int[N];
//         int[] minFromRight = new int[N];
        
//         maxFromLeft[0] = arr[0];
//         for(int i=1; i<N; i++) {
//             maxFromLeft[i] = Math.max(maxFromLeft[i-1], arr[i]);
//         }
        
//         minFromRight[N-1] = arr[N-1];
//         for(int i=N-2; i>=0; i--) {
//             minFromRight[i] = Math.min(minFromRight[i+1], arr[i]);
//         }
        
//         int ans = 1;
//         for(int i=0; i<N-1; i++) {
//             if(maxFromLeft[i] <= minFromRight[i+1])
//                 ans++;
//         }
//         return ans;
//     }
// }

class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int maxTillNow = 0;
        
        for(int num: arr) {
            maxTillNow = num;
            
            while(!stack.isEmpty() && stack.peek() > num)
                maxTillNow = Math.max(maxTillNow, stack.pop());
            
            stack.add(maxTillNow);
        }
        
        return stack.size();
    }
}