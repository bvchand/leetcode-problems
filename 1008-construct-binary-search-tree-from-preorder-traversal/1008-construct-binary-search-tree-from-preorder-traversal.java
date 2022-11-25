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
Iterative - using stack
space: O(N)
time: O(N)
*/
class Solution {    
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.add(root);
        
        // traverse through the preorder array one-by-one
        for (int i=1; i<preorder.length; i++) {
            TreeNode parent = stack.peek();
            TreeNode child = new TreeNode(preorder[i]);
            
            while (!stack.isEmpty() && child.val > stack.peek().val) {
                parent = stack.pop();
            }
            
            if (child.val < parent.val)     parent.left = child;
            else parent.right = child;
            stack.push(child);
        }
        return root;
    }
}


// /*
// Recursion
// space: O(N)
// time: O(N)
// */
// class Solution {
//     public int[] preorder;
//     public int index;
    
//     public TreeNode helper(int lower, int upper) {
//         if (index == preorder.length)
//             return null;
        
//         int value = preorder[index];
        
//         if (value < lower || value > upper)
//             return null;
        
//         index++;
//         TreeNode root = new TreeNode(value);
//         root.left = helper(lower, value);
//         root.right = helper(value, upper);
        
//         return root;
//     }
    
//     public TreeNode bstFromPreorder(int[] preorder) {
//         this.preorder = preorder;
//         index = 0;
//         return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
//     }
// }