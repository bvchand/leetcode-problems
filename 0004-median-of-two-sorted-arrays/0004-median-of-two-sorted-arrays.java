class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int M = nums1.length, N = nums2.length;
        int totalLen = M + N;
        
        // swapping if first array is greater
        if(M > N) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        //perform binary search on nums1
        int left = 0, right = M;
        while(left <= right) {
            int cut1 = (left + right)/2;     // no. of elements in nums1
            int cut2 = (totalLen + 1)/2 - cut1;           // no. of elements in nums2
            
            // System.out.println(cut1 + " " + cut2);
            
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];
            int right1 = cut1 == M ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == N ? Integer.MAX_VALUE : nums2[cut2];
            
            // System.out.println(left1 + " " + right1 + " " + left2 + " " + right2);
           
            if(left1 <= right2 && left2 <= right1)
                return (totalLen % 2 == 0) ? ((double) Math.max(left1, left2) +  (double) Math.min(right1, right2)) / 2 : (double) Math.max(left1, left2);
            
            else if(left2 > right1)
                left = cut1 + 1;
            else
                right = cut1 - 1;
        }
        return 0;
    }
}