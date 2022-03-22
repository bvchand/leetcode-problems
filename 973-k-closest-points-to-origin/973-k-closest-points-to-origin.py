class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        def square_distance(point):
            x,y = point
            return x**2+y**2
        """
        heapq is by default a min heap.
        simulate max heap functionality in a min heap data structure by inserting -dist instead of dist
        
        plain sort - O(nlogn)
        heapify - O(n)
        """
        minheap = [[square_distance(points[i]), points[i][0], points[i][1]] for i in range(len(points))]      # [(-dist, point)]
        heapq.heapify(minheap)
        
        res = []
        
        while k > 0:
            dist, x, y = heapq.heappop(minheap)
            res.append([x, y])
            k -= 1
        
        return res
    
    
    """
    time: O(k log(n))
    space: O(n)
    """
        