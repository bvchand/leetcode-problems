class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        symbols = ['+', '-', '/', '*']
        res = 0
        
        if len(tokens) == 1: return int(tokens[0])
        
        for el in tokens:
            res = 0
            # print(stack)
            if el not in symbols:  
                stack.append(el)
                continue
            b = int(stack.pop())
            a = int(stack.pop())
            # print(a, b)
            if el == '+':   res = a+b
            elif el == '-': res = a-b
            elif el == '*': res = a*b
            else: res = int(a/b)
            stack.append(res)
         
        return res
                