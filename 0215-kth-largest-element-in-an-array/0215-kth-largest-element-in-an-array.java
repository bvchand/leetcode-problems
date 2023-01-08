// quick select (version of quick sort) - iterative
// time: O(N) ; space: O(1)

class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // partition
    private int partition(int[] nums, int start, int end) {
        Random ran = new Random();  
        int pivotIdx = start + ran.nextInt(end - start);
        int pivot = nums[pivotIdx];

        swap(nums, pivotIdx, end);  // take the pivot to the end
        int storeIdx = start;       // index to store move the element smaller than the pivot to
        
        for(int i = start; i <= end; i++) {
            if(nums[i] < pivot) {
                swap(nums, storeIdx, i);
                storeIdx++;
            }
        }
        // take the pivot to the correct position
        swap(nums, storeIdx, end);
        return storeIdx;
    }
    
    private int quickSelect(int[] nums, int start, int end, int k_smallest) {                      
        if(start == end)
            return nums[start];
        
        int pivotPos = partition(nums, start, end);
        
        if(k_smallest == pivotPos)
            return nums[pivotPos];
        else if(k_smallest < pivotPos) {
            return quickSelect(nums, start, pivotPos-1, k_smallest);
        }
        return quickSelect(nums, pivotPos+1, end, k_smallest); 
    }
    
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int k_smallest = n-k;
        return quickSelect(nums, 0, n-1, k_smallest);
    } 
}


// /*
// time: O(Nlogk)
// space: O(k)
// */
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//         for (int n: nums) {
//             minHeap.add(n);
//             while(minHeap.size() > k)
//                 minHeap.poll();
//         }
//         return minHeap.peek();
//     }
// }