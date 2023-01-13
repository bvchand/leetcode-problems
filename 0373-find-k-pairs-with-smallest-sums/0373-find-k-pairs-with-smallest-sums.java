class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        
        // minheap
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) ->((a.get(0) + a.get(1)) - (b.get(0) + b.get(1))));
        
        for(int i=0; i<Math.min(m, k); i++) {
            pq.offer(Arrays.asList(nums1[i], nums2[0], 0));
        }
        
        while(k != 0 && !pq.isEmpty()) {
            List<Integer> curr = pq.poll();
            int num1 = curr.get(0), num2 = curr.get(1), idx = curr.get(2);
            res.add(Arrays.asList(num1, num2));
            if(idx < n-1) {
                pq.offer(Arrays.asList(num1, nums2[idx+1], idx+1));
            }
            k--;
        }
        
        return res;
    }
}