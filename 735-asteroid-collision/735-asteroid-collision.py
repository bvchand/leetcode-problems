class Solution:
    def asteroidCollision(self, ast: List[int]) -> List[int]:
        stack = [ast[0], ]
        for i in range(1, len(ast)):
            while stack and ast[i] < 0 and stack[-1] > 0:
                if abs(stack[-1]) < abs(ast[i]):
                    stack.pop()
                    continue
                elif abs(stack[-1]) == abs(ast[i]):
                    stack.pop()
                break
            else:
                stack.append(ast[i])
        
        return stack