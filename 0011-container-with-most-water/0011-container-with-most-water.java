class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxArea = 0;
        
        while (left < right) {
            int width = right - left;
            int leftHt = height[left], rightHt = height[right];
            maxArea = Math.max(maxArea, Math.min(leftHt, rightHt) * width);
            if(leftHt <= rightHt)
                left++;
            else
                right--;
        }
        return maxArea;
    }
}