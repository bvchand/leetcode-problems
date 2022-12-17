/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

// iterative
class Solution {
    
    public Node flatten(Node head) {
        if(head == null)
            return null;
        
        Node dummyHead = new Node(-1, null, head, null);
        Node curr, prev = dummyHead;
        
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        
        while(!stack.isEmpty()) {
            curr = stack.pop();
            curr.prev = prev;
            prev.next = curr;
            
            if(curr.next != null)
                stack.push(curr.next);
            
            if(curr.child != null) {
                stack.push(curr.child);
                curr.child = null;
            }
            
            prev = curr;
        }
        
        head.prev = null;
        return head;
    }
}

// class Solution {
    
//     public Node flattenDFS(Node prev, Node curr) {
//         if(curr == null)
//             return prev;
        
//         // enforce the connection between the "current" node and "child" node
//         curr.prev = prev;
//         prev.next = curr;
        
//         // before calling the function for parent node as prev and child node as curr, save the "parent.next", so that we can connect the new tail to this node
//         Node tempNext = curr.next;
        
//         // call to connect the parent and child -- whatever node the recursive call will return is the new tail found till now
//         Node tailTillNow = flattenDFS(curr, curr.child);
//         curr.child = null;
        
//         // now connect the new tail to the previous saved "next" node
//         return flattenDFS(tailTillNow, tempNext);
//     }
    
//     public Node flatten(Node head) {
//         if(head == null)
//             return null;
        
//         Node dummyNode = new Node(-1, null, head, null);
        
//         flattenDFS(dummyNode, head); 
        
//         head.prev = null;   // cut of the link to the dummyHead from head
        
//         return head;
//     }
// }

// // time and space: O(n)