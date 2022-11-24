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
Approach = BFS
space = O(N)
time = O(N)
*/

class Solution {
    public int minDepth(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        if (root == null)
            return 0;
        
        int currDepth = 0;
        queue.add(new Pair(root, 1));
        
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.poll();    // first element
            TreeNode currNode = curr.getKey();
            currDepth = curr.getValue();
            
            if (currNode.left == null && currNode.right == null)
                break;
            
            if (currNode.left != null)
                queue.add(new Pair(currNode.left, currDepth+1));
            if (currNode.right != null)
                queue.add(new Pair(currNode.right, currDepth+1));
        }
        return currDepth;
    }
} 


// -------------------------------------------------------------------------------------------------------------------

// /*
// Approach = DFS
// space = O(N)
// time = O(N)
// */

// class Solution {
//     public int minDepth(TreeNode root) {
//         Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        
//         if (root == null)
//             return 0;

//         stack.add(new Pair(root, 1));
        
//         int min_depth = Integer.MAX_VALUE;
        
//         while (!stack.isEmpty()) {
//             Pair<TreeNode, Integer> curr = stack.pop();
            
//             TreeNode currNode = curr.getKey();
//             int currDepth = curr.getValue();
            
//             if (currNode.left == null && currNode.right == null)
//                 min_depth = Math.min(min_depth, currDepth);
            
//             if (currNode.right != null)
//                 stack.push(new Pair(currNode.right, currDepth+1));
            
//             if (currNode.left != null)
//                 stack.push(new Pair(currNode.left, currDepth+1));
//         }
        
//         return min_depth;
//     }
// } 

// -------------------------------------------------------------------------------------------------------------------

// /*
// Approach: Recursive
// space: O(1)
// time: O(n)
// */
// class Solution {
//     public int minDepth(TreeNode root) {
//         if (root == null)
//             return 0;
        
//         if (root.left == null && root.right == null)
//             return 1;
        
//         int min_depth = Integer.MAX_VALUE;
//         if (root.left != null) {
//             min_depth = Math.min(min_depth, minDepth(root.left));
//         }
        
//         if (root.right != null) {
//             min_depth = Math.min(min_depth, minDepth(root.right));
//         }
        
//         return min_depth + 1;
//     }
// } 