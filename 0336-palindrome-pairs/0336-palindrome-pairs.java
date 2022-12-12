class TrieNode {
    char val;
    TrieNode[] children;
    int wordEndingIndex;
    List<Integer> otherWords;
    String wholeWord;
    
    public TrieNode(char ch) {
        this.val = ch;
        this.children = new TrieNode[26];
        this.wordEndingIndex = -1;
        this.otherWords = new ArrayList<>();
        this.wholeWord = null;
    }
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public TrieNode addWords(String[] words) {
        TrieNode root = new TrieNode('\0');
        
        for(int wordId = 0; wordId < words.length; wordId++) {
            String word = words[wordId];            
            TrieNode curr = root;

            for(int i = word.length()-1; i >= 0; i--) {
                    
                int idx = word.charAt(i) - 'a';
                if(curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode(word.charAt(i));
                }
                
                // check if rest of the string is a palindrome or not
                if(isPalindrome(word, 0, i))
                    curr.otherWords.add(wordId);
                
                curr = curr.children[idx];
            }
            curr.wordEndingIndex = wordId;
            curr.wholeWord = word;
        }
        
        return root;
    }
    
    public void search(String[] words, TrieNode root) {
        for(int wordId = 0; wordId < words.length; wordId++) {
            String word = words[wordId];            
            TrieNode curr = root;

            for(int i = 0; i < word.length(); i++) {
                // Check for pairs of case 3.
                if(curr.wordEndingIndex != -1 && curr.wordEndingIndex != wordId && isPalindrome(word, i, word.length()-1))
                    result.add(Arrays.asList(wordId, curr.wordEndingIndex));
                    
                int nextIdx = word.charAt(i) - 'a';
                curr = curr.children[nextIdx];
                if(curr == null)
                    break;
            }
            
            if (curr == null) continue;
            
            // Check for pairs of case 1. Note the check to prevent non distinct pairs.
            if(curr.wordEndingIndex != -1 && curr.wordEndingIndex != wordId)
                result.add(Arrays.asList(wordId, curr.wordEndingIndex));
            
            // Check for pairs of case 2.
            for(int other: curr.otherWords) {
                if(wordId != other)
                    result.add(Arrays.asList(wordId, other));
            }
        }
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = addWords(words);
        search(words, root);
        return result;
    }
    
    public boolean isPalindrome(String word, int i, int j) {
        while(i < j) {
            if(word.charAt(i++) != word.charAt(j--))
                return false;
        }
        return true;
    }
}