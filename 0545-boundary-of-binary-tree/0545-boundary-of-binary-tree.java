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
    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
    public void addLeaves(TreeNode node, List<Integer> res) {
        if(isLeaf(node))
            res.add(node.val);
        
        else {
            if(node.left != null)
                addLeaves(node.left, res);
            if(node.right != null)
                addLeaves(node.right, res);
        }
    }
    
    public void reverse(List<Integer> res, int i) {
        int j = res.size()-1;
        while(i < j) {
            int temp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, temp);
            i++;
            j--;
        }
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        if(!isLeaf(root))
            res.add(root.val);
        
        TreeNode curr = root.left;
        while(curr != null) {
            if(!isLeaf(curr))
                res.add(curr.val);
            if(curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
        
        addLeaves(root, res);
        int rIdx = res.size();
        curr = root.right;
        while(curr != null) {
            if(!isLeaf(curr))
                res.add(curr.val);
            if(curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        reverse(res, rIdx);
        return res;
    }
}