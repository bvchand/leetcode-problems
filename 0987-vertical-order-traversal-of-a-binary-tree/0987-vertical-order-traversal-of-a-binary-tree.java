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
    Map<Integer, List<Pair<Integer, Integer>>> colMap = new TreeMap<>();
    
    public void bfs(TreeNode root) {
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new LinkedList<>();
        queue.offer(new Pair(root, new Pair(0, 0)));
        
        while(!queue.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> node = queue.poll();
            TreeNode curr = node.getKey();
            int level = node.getValue().getKey();   // row
            int index = node.getValue().getValue(); // col
            
            if(curr != null) {
                colMap.computeIfAbsent(index, val -> new ArrayList<>()).add(new Pair(level, curr.val));
                queue.offer(new Pair(curr.left, new Pair(level+1, index-1)));
                queue.offer(new Pair(curr.right, new Pair(level+1, index+1)));
            }
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        bfs(root);
        
        for(List<Pair<Integer, Integer>> colList: colMap.values()) {
            // System.out.println(colList);
            Collections.sort(colList, new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
                    if(a.getKey() == b.getKey())
                        return a.getValue() - b.getValue();
                    else
                        return a.getKey() - b.getKey();
                }
            });
            
            List<Integer> temp = new ArrayList<>();
            for(Pair<Integer, Integer> node: colList)
                temp.add(node.getValue());
            res.add(temp);
        }
        return res;
    }
}