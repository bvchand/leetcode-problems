class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()      
        
        i, word, sentence = 0, [], deque()
        
        while i < len(s):
            if s[i] == ' ' and word:
                sentence.appendleft(''.join(word))
                word = []
            elif s[i] != ' ':
                word.append(s[i])
            i += 1
            
        sentence.appendleft(''.join(word))
        
        return ' '.join(sentence)
            
        