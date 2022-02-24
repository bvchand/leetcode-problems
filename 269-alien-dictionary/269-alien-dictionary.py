"""
add all the chars in all the words to a dict of sets
create an adjacency list to map a char from a word to the smaller chars in the next word
traverse the adj list (by dfs) to see if there are no cycles
return the string

"""
class Solution:
    def alienOrder(self, words: List[str]) -> str:
        adj = {char:set() for word in words for char in word}
        
        for i in range(len(words)-1):
            for j in range(len(words[i])):
                if j >= len(words[i+1]):
                    return ""
                if words[i][j] != words[i+1][j]:
                    adj[words[i][j]].add(words[i+1][j])
                    break
        
        print(adj)
        visited = {}        # char:True/False;  True: cycle exists 
        res = []
        
        def dfs(char):
            if char in visited:     return visited[char]
            
            visited[char] = True
            for neighbor in adj[char]:
                if dfs(neighbor):   # cycle exists
                    return True
            visited[char] = False
            res.append(char)
        
        for char in list(adj):
            if dfs(char):   return ""
        
        return "".join(res[::-1])
        
                    
        
                        
            
                
                
        
    