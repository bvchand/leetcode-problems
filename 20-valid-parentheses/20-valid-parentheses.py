class Solution:
    def isValid(self, s: str) -> bool:
    
        """
        1. create a hash table of the paratheses
            {"(": ")"}
        2. traverse through the string
        2. check if the char is a key in the hash table and push the char into stack
        4. if the char is a closed paran, check the top of the stack
            if the top is eq. parathe of the current char, pop the stack
        5. return true if the stack is empty
        a : "()[]"
        b) "([)]"
        c) "((())"
        """
        
        paran_dict = {"(": ")", "{": "}", "[": "]"}
        stack = []  
        # for c in s.strip():
        #     if c in paran_dict.keys():
               
        
        for c in s:
            if c in paran_dict:   
                stack.append(c) 
            elif stack and c == paran_dict[stack[-1]]:
                stack.pop()
            else:
                return False
        return len(stack) == 0
        