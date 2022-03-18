class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:
        stack = []
        
        for i, building in enumerate(heights):
            if not stack or heights[stack[-1]] > building:
                stack.append(i)
            else:
                while stack and heights[stack[-1]] <= building:
                    stack.pop()
                stack.append(i)
        
        return stack

"""
time: O(N)
space: O(N)
"""
                
        