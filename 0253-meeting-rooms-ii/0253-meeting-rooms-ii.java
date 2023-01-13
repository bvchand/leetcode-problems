class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // minHeap for end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((x, y) -> (x-y));
        
        // sort the intervals based on the start date --> O(NlogN)
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        
        minHeap.offer(intervals[0][1]); // add the first end date
        
        for (int i=1; i<intervals.length; i++) {
            // if a current meeting is getting over on or before the curr start time --> remove that meeting from the heap
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            
            // add the current end time to the heap (regardless of room already available or new room needed)
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }
}

/**
sort --> O(NlogN)
heapify (extract the minimum) --> O(logN)
=> overall time = O(NlogN)

space = O(N) --> heap
*/