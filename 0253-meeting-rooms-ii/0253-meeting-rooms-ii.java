class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // minHeap for end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((x, y) -> (x-y));
        
        // sort the intervals based on the start date
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)  {
                return a[0] - b[0];
            }
        });
        
        minHeap.offer(intervals[0][1]); // add the first end date
        
        for (int i=1; i<intervals.length; i++) {
            // if a current meeting is getting over on or before the curr start time --> remove that meeting from the heap
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }
}