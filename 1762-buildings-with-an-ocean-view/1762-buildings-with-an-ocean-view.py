class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:
        stack = []
        
        for i, building in enumerate(heights):
            if not stack or stack[-1][0] > building:
                stack.append((building, i))
            else:
                while stack and stack[-1][0] <= building:
                    stack.pop()
                stack.append((building, i))
        
        return [i for h, i in stack]
                
        