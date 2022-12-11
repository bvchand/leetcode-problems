/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
DFS - recurisve --> to annotate the parents of each node
BFS - iterative (queue) --> to visit the children and parent nodes from the target until distance = k

*/
class Solution {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        
        // to annotate the parents of each node
        dfs(root, null);
        
        //BFS
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(null);
        queue.add(target);
        
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        seen.add(null);
        
        int dist = 0;
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                if(dist == k) {
                    for(TreeNode curr: queue) {
                        result.add(curr.val);
                    }
                    break;
                }
                queue.offer(null);
                dist++;
            } else {
                if(!seen.contains(node.left)) {
                    queue.offer(node.left);
                    seen.add(node.left);                
                }
                if(!seen.contains(node.right)) {
                    queue.offer(node.right);
                    seen.add(node.right);                
                }
                TreeNode par = this.parent.get(node);
                if(!seen.contains(par)) {
                    queue.offer(par);
                    seen.add(par);                
                }
            }
        }
        return result;
        
    }
    
    public void dfs(TreeNode node, TreeNode par) {
        if(node != null) {
            this.parent.put(node, par);
            this.dfs(node.left, node);
            this.dfs(node.right, node);
        }
    }
        
}