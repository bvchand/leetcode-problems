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
    public int closestValue(TreeNode root, double target) {
        TreeNode curr = root;
        double minDiff = Double.MAX_VALUE;
        TreeNode minNode = null;
        
        while (curr != null) {
            double diff = Math.abs(curr.val - target);
            if (diff < minDiff) {
                minDiff = diff;
                minNode = curr;
            }
            
            if (target < curr.val)
                curr = curr.left;
            else
                curr = curr.right;
        }
        return minNode.val;
    }
}