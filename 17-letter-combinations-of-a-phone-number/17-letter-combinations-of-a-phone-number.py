class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        res = []
        char_combo = {  '2':'abc', 
                        '3':'def', 
                        '4':'ghi', 
                        '5':'jkl', 
                        '6':'mno', 
                        '7':'pqrs', 
                        '8':'tuv', 
                        '9':'wxyz'  }
        
        def backtrack_helper(index, curr_str):
            # base case
            if len(curr_str) == len(digits):
                res.append(curr_str)
                return
            
            curr_digit = digits[index]                  # 2
            digit_to_chars = char_combo[curr_digit]     # [a, b, c]
            
            for c in digit_to_chars:                    # c='a', c='b', c='c'
                backtrack_helper(index+1, curr_str+c)
        
            return
        if digits != "":    backtrack_helper(0, '')
        return res
                
            
            
            
                
        
        
            
        