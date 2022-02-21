class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        order = {key: value for value, key in enumerate(order)} 
        n = len(words)
        
        result = False
        if n <= 1:  return True
        
        print(order)
        
        for i in range(n-1):
            for j in range(len(words[i])):
                if j >= len(words[i+1]):
                    return False
                if words[i][j] != words[i+1][j]:
                    if order[words[i][j]] > order[words[i+1][j]]:
                        return False
                    break
                    
        return True