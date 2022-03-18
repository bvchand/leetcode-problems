class Solution:
    def findBuildings(self, heights: List[int]) -> List[int]:
        """
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
        """   
        
        res = []
        maxheight = -1
        n = len(heights)-1
        
        for i in range(n, -1, -1):
            if heights[i] > maxheight:
                res.append(i)
                maxheight = heights[i]
        
        return reversed(res)
        
        """
        time = O(N)
        space = O(1)
        """
        