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

// BFS
class Solution {
    public int maxLevelSum(TreeNode root) {        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode marker = null;
        queue.offer(root);
        queue.offer(marker);
        
        int maxSum = Integer.MIN_VALUE, maxLevel = 1, currSum = 0, currLevel = 1;
        while(queue.size() > 1) {       // since there will always be at least one marker node in the queue
            TreeNode node = queue.poll();
            
            if(node != marker) {
                currSum += node.val;
                if(node.left != null)   queue.offer(node.left);
                if(node.right != null)  queue.offer(node.right);
            } else {
                if(maxSum < currSum) {
                    maxSum = currSum;
                    maxLevel = currLevel;
                }
                currSum = 0;
                currLevel++;
                queue.offer(marker);
            }
        }
        
        // check if the last level has the largest sum
        if (currSum > maxSum) {
            maxLevel = currLevel;
        }

        return maxLevel;
    }
}