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
Recursive
Space = O(1)
Time = O(N)

*/
class Solution {
    public int result = 0;
    
    public int helper (TreeNode root, int currMin, int currMax) {
        int possibleResult = Math.max(Math.abs(currMin-root.val), Math.abs(currMax-root.val));
        result = Math.max(possibleResult, result);
        
        currMin = Math.min(currMin, root.val);
        currMax = Math.max(currMax, root.val);
        
        if(root.left != null)
            helper(root.left, currMin, currMax);
        if(root.right != null)
            helper(root.right, currMin, currMax);
        
        return result;
    }
    
    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        return helper(root, root.val, root.val);
    }
}