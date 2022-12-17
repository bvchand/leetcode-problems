/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    
    public Node flattenDFS(Node prev, Node curr) {
        if(curr == null)
            return prev;
        
        curr.prev = prev;
        prev.next = curr;
        
        Node tempNext = curr.next;
        
        Node tailTillNow = flattenDFS(curr, curr.child);
        curr.child = null;
        
        return flattenDFS(tailTillNow, tempNext);
    }
    
    public Node flatten(Node head) {
        if(head == null)
            return null;
        
        Node dummyNode = new Node(-1, null, head, null);
        
        flattenDFS(dummyNode, head);
        head.prev = null;
        
        return head;
    }
}