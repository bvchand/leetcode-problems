class Solution:
    def calculate(self, s: str) -> int:
        value = []
        curr_num = 0
        operator = '+'
        s = ''.join(s.split())
        
        for i in range(len(s)):
            char = s[i]
            if char in string.digits:
                curr_num = curr_num * 10 + int(char)
            if char in '+-*/' or i == len(s)-1: 
                if operator == '+':
                    value.append(curr_num)
                elif operator == '-':
                    value.append(-curr_num)
                elif operator == '*':
                    value[-1] *= curr_num
                elif operator == '/':
                    value[-1] = int(value[-1]/curr_num)
                curr_num = 0
                operator = char
                
        return sum(value)
            