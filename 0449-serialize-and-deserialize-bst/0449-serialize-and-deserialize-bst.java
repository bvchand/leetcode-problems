/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    public StringBuilder preorderHelper(TreeNode root, StringBuilder sb) {
        if (root == null)
            return sb;
        sb.append(root.val + " ");
        preorderHelper(root.left, sb);
        preorderHelper(root.right, sb);
        return sb;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if (root == null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        String tree = new String();
        
        sb = preorderHelper(root, sb);
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
    
    private int index = 0;
    public TreeNode constructTree(String[] preorder, int lower, int upper) {
        if (index == preorder.length)
            return null;
        
        int value = Integer.valueOf(preorder[index]);
        
        if (value < lower || value > upper)
            return null;
        
        index++;
        TreeNode root = new TreeNode(value);
        root.left = constructTree(preorder, lower, value);
        root.right = constructTree(preorder, value, upper);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 0)
            return null;
        String[] preorder = data.split(" ");
        return constructTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;