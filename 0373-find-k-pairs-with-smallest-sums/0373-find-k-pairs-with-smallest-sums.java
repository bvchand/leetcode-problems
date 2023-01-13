// priority queue
// time: O(klogk) space:O(k)

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        
        // minheap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->((a[0] + a[1]) - (b[0] + b[1])));
        
        for(int i=0; i<Math.min(m, k); i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        // every iteration --> poll the least pair till now, add that to the res and add the next pair by incrementing the nums2 index
        while(k != 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int num1 = curr[0], num2 = curr[1], nums2Idx = curr[2];
            
            res.add(Arrays.asList(num1, num2));
            
            if(nums2Idx < n-1) {
                pq.offer(new int[]{num1, nums2[nums2Idx+1], nums2Idx+1});
            }
            k--;
        }
        
        return res;
    }
}