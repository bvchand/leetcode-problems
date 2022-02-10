class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        def square_distance(point):
            x,y = point
            return math.sqrt(x**2+y**2)
        heap = [(-square_distance(points[i]), points[i]) for i in range(k)]      # [(dist,point)]
        heapq.heapify(heap)
        
        for i in range(k, len(points)):
            new_dist = -square_distance(points[i])
            smalleest_dist_so_far = heap[0][0]
            if new_dist > smalleest_dist_so_far:
                heapq.heappushpop(heap, (new_dist, points[i]))
        return [i for (_,i) in heap]
        