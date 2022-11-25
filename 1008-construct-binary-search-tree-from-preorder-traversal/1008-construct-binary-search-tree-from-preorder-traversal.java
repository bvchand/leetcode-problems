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
    public int[] preorder;
    public int index;
    
    public TreeNode helper(int lower, int upper) {
        if (index == preorder.length)
            return null;
        
        int value = preorder[index];
        
        if (value < lower || value > upper)
            return null;
        
        index++;
        TreeNode root = new TreeNode(value);
        root.left = helper(lower, value);
        root.right = helper(value, upper);
        
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        index = 0;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}