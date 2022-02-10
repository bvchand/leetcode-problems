class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        result = 0
        intervals.sort()
        free_rooms = []        # add the end times of the meetings in a min-heap
        heapq.heappush(free_rooms, intervals[0][1])
        
        for i in range(1, len(intervals)):
            if intervals[i][0] >= free_rooms[0]:
                heapq.heappop(free_rooms)
            heapq.heappush(free_rooms, intervals[i][1])
                
        return len(free_rooms)
                
                
            