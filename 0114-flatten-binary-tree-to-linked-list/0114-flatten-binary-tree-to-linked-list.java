/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
iterative
space: O(1)
*/

class Solution {
    
    public void flatten(TreeNode node) {
        TreeNode root = node;
        while(root != null) {
            if(root.left != null) {
                TreeNode rightMost = root.left;
                
                while(rightMost.right != null)
                    rightMost = rightMost.right;
                
                rightMost.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}

/*
Similar to postorde traversal (but going to right first)
time & space: O(N)
*/

// class Solution {
//     public TreeNode currNode = null;
    
//     public void flatten(TreeNode root) {
//         if(root != null) {
//             flatten(root.right);
//             flatten(root.left);
//             root.right = currNode;
//             root.left = null;
//             currNode = root;
//         }
//     }
// }



// class Solution {
//     Queue<TreeNode> queue = new LinkedList<>();
    
//     public void preorder(TreeNode node) {
//         if(node != null) {
//             queue.offer(node);
//             preorder(node.left);
//             preorder(node.right);
//         }
//     }
    
//     public void flatten(TreeNode root) {
//         preorder(root);
        
//         TreeNode curr = queue.poll();
        
//         while(!queue.isEmpty()) {
//             TreeNode next = queue.poll();
//             curr.left = null;
//             curr.right = next;
//             curr = next;
//         }            
//     }
// }