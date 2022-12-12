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
class Solution {
    Queue<TreeNode> queue = new LinkedList<>();
    
    public void preorder(TreeNode node) {
        if(node != null) {
            queue.offer(node);
            preorder(node.left);
            preorder(node.right);
        }
    }
    
    public void flatten(TreeNode root) {
        preorder(root);
        
        TreeNode curr = queue.poll();
        
        while(!queue.isEmpty()) {
            TreeNode next = queue.poll();
            curr.left = null;
            curr.right = next;
            curr = next;
        }            
    }
}