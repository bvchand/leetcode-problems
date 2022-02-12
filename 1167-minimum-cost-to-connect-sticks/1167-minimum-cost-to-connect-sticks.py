class Solution:
    def connectSticks(self, sticks: List[int]) -> int:
        costs = 0
        heapq.heapify(sticks)
        
        while len(sticks) > 1:
            stick1 = heapq.heappop(sticks)
            stick2 = heapq.heappop(sticks)
            
            costs += (stick1 + stick2)
            heapq.heappush(sticks, stick1 + stick2)
        
        return costs
        