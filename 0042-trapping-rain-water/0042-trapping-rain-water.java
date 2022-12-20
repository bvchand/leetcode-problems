class Solution {
    public int trap(int[] height) {
        int N = height.length;
        
        int left = 0, right = N-1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        
        while(left <= right) {
            if(height[left] <= height[right]) {
                if(leftMax <= height[left]) {
                    leftMax = height[left];
                } else {
                    ans += (leftMax - height[left]);
                }
                left++;
            } else {
                if(rightMax <= height[right]) {
                    rightMax = height[right];
                } else {
                    ans += (rightMax - height[right]);
                }
                right--;
            }
        }

        return ans;
    }
}

// Dynamic programming; time and space --> O(N)

// class Solution {
//     public int trap(int[] height) {
//         int N = height.length;
//         int[] maxLeft = new int[N];
//         int[] maxRight = new int[N];
//         int leftMax = 0, rightMax = 0;
        
//         int ans = 0;
        
//         for(int i = 0; i < N; i++) {
//             leftMax = Math.max(height[i], leftMax);
//             maxLeft[i] = leftMax;
//         }
        
//         for(int i = N-1; i >= 0; i--) {
//             rightMax = Math.max(height[i], rightMax);
//             maxRight[i] = rightMax;
//         }
        
//         for(int i = 1; i < N-1; i++) {
//             ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
//         }
        
//         return ans;
//     }
// }

// Dynamic programming; time and space --> O(N)