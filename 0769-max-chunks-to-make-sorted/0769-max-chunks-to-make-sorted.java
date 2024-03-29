class Solution {
    public int maxChunksToSorted(int[] arr) {
        int N = arr.length;
        int count = 0;
        
        int maxTillNow = Integer.MIN_VALUE;
        
        for(int i=0; i<N; i++) {
            maxTillNow = Math.max(arr[i], maxTillNow);
            if(maxTillNow == i)
                count++;
        }
        return count;
    }
}


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
        
//         int count = 1;
//         for(int i=0; i<N-1; i++) {
//             if(minFromRight[i+1] >= maxFromLeft[i])
//                 count++;
//         }
        
//         return count;
//     }
// }