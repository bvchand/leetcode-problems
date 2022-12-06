class Trie {
    
    public class Node {
        public char val;
        public boolean isEnd;
        public String wholeWord;
        public Node[] children;
        
        public Node(char val) {
            this.val = val;
            this.isEnd = false;
            this.wholeWord = null;
            this.children = new Node[26];
        }
        
    }
    
    public Node root;

    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new Node(c);
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
        curr.wholeWord = word;
    }
    
    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isEnd == true;
    }
    
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }
    
    public Node getNode(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null)
                return null;
            curr = curr.children[c - 'a'];
        }
        return curr;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */