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
BFS
*/

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int deepestLevel = 0, sum = 0;
        
        if (root == null)
            return 0;
        
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.poll();
            TreeNode currNode = curr.getKey();
            int currLevel = curr.getValue();
                            
            if (currNode.left == null && currNode.right == null) {
                if (deepestLevel < currLevel) {
                    sum = currNode.val;
                    deepestLevel = currLevel;
                } else if (deepestLevel == currLevel) {
                    sum += currNode.val;
                }
                continue;
            }
            
            if (currNode.left != null) {
                queue.add(new Pair(currNode.left, currLevel+1));
                // deepestLevel = Math.max(currLevel+1, deepestLevel);
            }
            
            if (currNode.right != null) {
                queue.add(new Pair(currNode.right, currLevel+1));
                // deepestLevel = Math.max(currLevel+1, deepestLevel);
            }
            
        }
        
        return sum;
    }
}