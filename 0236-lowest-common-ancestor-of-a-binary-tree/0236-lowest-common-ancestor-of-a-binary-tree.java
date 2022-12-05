/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode ans = null;
        
    public int helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return 0;
        
        int mid = (root == p || root == q) ? 1 : 0;
        
        int left = helper(root.left, p, q);
        int right = helper(root.right, p, q);
        
        if (left + right + mid >= 2) 
            this.ans = root;
        
        return (left + right + mid > 0) ? 1 : 0;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return this.ans;    
    }
}