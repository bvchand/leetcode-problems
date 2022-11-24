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
    
    public int diameter = 0;
    
    public int helper(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftpath = helper(root.left);
        int rightpath = helper(root.right);
        
        diameter = Math.max(diameter, leftpath+rightpath);
        
        return Math.max(leftpath, rightpath) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }
}