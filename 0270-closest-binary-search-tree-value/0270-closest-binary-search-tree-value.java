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
Iterative
space = O(1)
time = O(H)
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
            
            curr = target < curr.val ? curr.left : curr.right;
        }
        return minNode.val;
    }
}