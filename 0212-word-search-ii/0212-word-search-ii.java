class Solution {
    public char[][] board;
    public List<String> result = new ArrayList<String>();
    public int rows, cols;
    
    
    class TrieNode {
        char val;
        TrieNode[] children;
        String wholeWord;
        boolean isEnd;
        
        public TrieNode(char val) {
            this.val = val;
            this.wholeWord = null;
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }
    
    public TrieNode insertWords(String[] words) {
        TrieNode root = new TrieNode('\0');
        for(String word: words) {
            TrieNode curr = root;
            for(char ch: word.toCharArray()) {
                if(curr.children[ch - 'a'] == null)
                    curr.children[ch - 'a'] = new TrieNode(ch);
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
            curr.wholeWord = word;
        }
        return root;
    }
    
    public void dfs(int row, int col, TrieNode root) {
        
        if(row < 0 || row >= rows || col < 0 || col >= cols)
            return;
        
        int currIndex = this.board[row][col] - 'a';
    
        if(this.board[row][col] == '$' || root.children[currIndex] == null)
            return;
        
        TrieNode currNode = root.children[currIndex];
        
        if(currNode.isEnd) {
            this.result.add(currNode.wholeWord);
            currNode.isEnd = false;
        }

        char temp = this.board[row][col];
        this.board[row][col] = '$';
        
        dfs(row+1, col, currNode);
        dfs(row-1, col, currNode);
        dfs(row, col+1, currNode);
        dfs(row, col-1, currNode);
        
        this.board[row][col] = temp;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rows = this.board.length;
        this.cols = this.board[0].length;
        TrieNode root = insertWords(words);
        
        for(int r=0; r<this.rows; r++) {
            for(int c=0; c<this.cols; c++) {
                char ch = this.board[r][c];
                if(root.children[ch - 'a'] != null) {
                    dfs(r, c, root);
                }
            }
        }
        
        return this.result;
    }
}