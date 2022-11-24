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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        
        if (root == null)
            return res;
        
        queue.offer(new Pair(root, 0));
        // res.add(List.of(root.val));
        // System.out.println(res.toString());
        
        while (!queue.isEmpty()) {
            int nodesPerLevel = queue.size();
            LinkedList<Integer> nextNodes = new LinkedList<>();
            
            for (int i = 0; i < nodesPerLevel; i++) {
                Pair<TreeNode, Integer> curr = queue.poll(); //first element
                TreeNode currNode = curr.getKey();
                Integer currLevel = curr.getValue();
                
                if (currNode.left != null) {
                    queue.offer(new Pair(currNode.left, currLevel+1));
                }

                if (currNode.right != null) {
                    queue.offer(new Pair(currNode.right, currLevel+1));
                }
                
                if (currLevel % 2 == 0)     // currLevel = even (left to right; so add normally)
                    nextNodes.add(currNode.val);  
                else                        // currLevel = odd (right to left; so append as a the first element)
                    nextNodes.addFirst(currNode.val);
            }
            res.add(nextNodes);
        }

        return res;
    }
}