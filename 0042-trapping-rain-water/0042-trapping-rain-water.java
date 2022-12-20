class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        int leftMax = 0, rightMax = 0;
        
        int ans = 0;
        
        for(int i = 0; i < len; i++) {
            leftMax = Math.max(height[i], leftMax);
            maxLeft[i] = leftMax;
        }
        
        for(int i = len-1; i >= 0; i--) {
            rightMax = Math.max(height[i], rightMax);
            maxRight[i] = rightMax;
        }
        
        for(int i = 1; i < len-1; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        
        return ans;
    }
}