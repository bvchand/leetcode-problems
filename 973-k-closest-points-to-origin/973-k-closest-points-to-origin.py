class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        def square_distance(point):
            x,y = point
            return math.sqrt(x**2+y**2)
        points.sort(key=square_distance)
        return points[:k]
        
        